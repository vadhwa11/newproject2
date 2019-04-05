<%@ page import="java.util.Calendar"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>

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
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
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
<form name="foodHandler" method="post" action="">

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
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	Map<String, Object> map = new HashMap<String, Object>();
 	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
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
 	int hinId=0;
 	
 	if(request.getParameter("hinId") != null)
 	{
 		hinId = Integer.parseInt(request.getParameter("hinId"));
 	}
 	List<Object[]> tradeList = null;
 	if(map.get("tradeList") != null){
		tradeList = (List<Object[]>)map.get("tradeList");
	}
	
 %>
 
<div class="titleBg">
<h2>Free From Infection</h2>
</div>
<div class="clear"></div>

<div class="Block">

<label>Service No./ Pass No.<span>*</span></label>
<input type="text" name="serviceNo" id="serviceNo"  value="" MAXLENGTH="30" validate="Service No,metachar,yes"
	onblur="getPatientDetails();"/>
<script>
function getPatientDetails()
{
var hinNo='';
hinNo=document.getElementById('serviceNo').value;

if(validateMetaCharacters(hinNo))
{
	submitProtoAjaxWithDivName('foodHandler','/hms/hms/mis?method=getHinNoForFreeFromInfection&flag='+hinNo,'hinDiv')
}
}
</script>
<div id="hinDiv">
<label>HIN</label> 
<input	type="text" name="<%=HIN_NO%>" value=""	MAXLENGTH="30" onchange=""/>
</div>


<div id="foodHandlerDiv">

<label >Name</label>
<input  type="text" name="name" validate="name, string,no" id="nameId" value="" />

<label >Rank</label>
<input  type="text" name="rank" validate="name, string,no" id="rankId" value="" />

<label >Patient Name</label>
<input  type="text" name="patientName" validate="patientName, string,no" id="patientNameId" value="" />

<label >Relation</label>
<input  type="text" name="relation" validate="relation, string,no" id="relationid" value="" />

<div class="clear"></div>

<label >Age</label>
<input  type="text" name="age"  validate="name, number,no" id="ageId" value="" />

<label >Gender</label>
<input  type="text" name="sex" validate="name, string,no" id="sexId" value="" />

<label >Trade</label>
<input  type="text" name="trade" validate="name, string,no" id="tradeId" value="" />

<div class="clear"></div>

<label >Unit</label>	
<input  type="text" name="unit" validate="name, string,no" id="unitId" value="" />

</div>

<label>Place</label>
<input type="text" name="mess"  maxlength="49" value=""  />


<!--<label>Trade/ Branch</label>
<select id="tradeId" name="<%=TRADE_ID%>"	validate="Trade,string,no" tabindex="1"	>
	<option value="0">Select</option>
	<%for(Object[] trade :tradeList){ %>
	<option value=<%=trade[0]%>><%=trade[1] %></option>
	<%} %>
</select>

-->

<label>Nails/ Hair</label>
<input type="text" name="nailHair"   maxlength="49"  value=""  />

<div class="clear"></div>

<label>Skin</label>
<input type="text" name="skin"  maxlength="49"  value=""  />

<label>Deworming Status</label>
<input type="text" name="dewormingStatus"   maxlength="49" value=""   />

<label>Stool Test</label>
<input type="text" name="stoolTest"   maxlength="49" value=""   />

<div class="clear"></div>

<label>General Exam</label>
<textarea name="generalExam" cols="30" rows="10" maxlength="50" onkeyup="chkLength(this,50);" onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>

<!--<input type="text" name="generalExam"  maxlength="49" value=""  />-->

<label>Remarks FFI</label>
<textarea name="remarksFFI" cols="30" rows="10" maxlength="50" onkeyup="chkLength(this,50);" onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>

<!--<input type="text" name="remarksFFI"  maxlength="49" value=""  />

<label>Immunization</label>
<input type="button" class="button" value="Immunization" name="immun"   
   onClick="javascript:openPopupForImmunization();"  />
-->

</div>

<h4>IMMUNIZATION<a href="javascript:animatedcollapse.toggle('slide11')"></a></h4>

<div class="Block"><input tabindex="1" name="Button" type="button" class="button" value="Immunization"
onClick="javascript:openPopupForImmunization();" /></div>


<div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear paddingTop15"></div>

<input type="button" name="Submit11" id="addbutton" value="Submit" class="button" accesskey="a" 
onclick="submitForm('foodHandler','/hms/hms/mis?method=submitFoodHandlerJsp');" />

<script>


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

function openPopupForImmunization(){
	var hinNo='';
	hinNo=document.getElementById('hin_Id').value;
	if(validateMetaCharacters(hinNo) && (hinNo !=""))
	{
		newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&hinId='+hinNo+'&flag=sho','windowRef','width=1000,height=400,scrollbars = yes');
		 //newwindow = window.open('/hms/hms/registration?method=openPopupForImmunization&hinId='+document.getElementById('hinId').value+'&flag=medicalExam','windowRef','width=1000,height=400,scrollbars = yes');
	}else{
		return false;
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

</script>

</form>

