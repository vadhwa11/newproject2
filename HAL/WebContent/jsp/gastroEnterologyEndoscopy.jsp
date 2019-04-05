<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdGastroEnterologyEndoscopy"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>



<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />



<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

	function showJSP(formName)
	{
  		obj = eval('document.'+formName)
  		obj.action = "/hms/hms/opd?method=viewGastroEnterologyEndoscopy&flag=prev&viewScreen=no";
 		obj.submit();
	}
	function showBackJSP(formName)
	{
  		obj = eval('document.'+formName)
  		obj.action = "/hms/hms/opd?method=showWaitingPatientListJsp";
 		obj.submit();
	}
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
function fillDiagnosisCombo(val) {

	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    //alert("function called---"+id)
	    if(id ==""){
		  return;
		}else{
		   		obj =document.getElementById('diagnosisId');
				obj.length = document.getElementById('diagnosisId').length;

	        	obj.length++;
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				obj.options[obj.length-1].selected=true
				document.getElementById('icd').value =""
		}
}
</script>
<script type="text/javascript">
function blankSpace()
{

var b1 = document.getElementById('b1').value ;
var b2 = document.getElementById('b2').value ;
var b3= document.getElementById('b3').value ;
var b4 = document.getElementById('b4').value ;
var b5= document.getElementById('b5').value ;
var b6 = document.getElementById('b6').value ;
var b7 = document.getElementById('b7').value ;
var b8 = document.getElementById('icd').value ;


if((b1=="0")&&(b2=="")&&(b3=="")&&(b4=="")&&(b5=="")&&(b6=="")&&(b7=="")&&(icd==0))
{
	alert("Please give some fields.");
	return false;
}
else
{
	return true;
}
}
</script>

<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DischargeIcdCode> dischargeIcdCodeList = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}

		 List patientDataList = new ArrayList();

	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}


	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	OpdGastroEnterologyEndoscopy opdGastroEnterologyEndoscopy = null ; 

	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	if(map.get("opdGastroEnterologyEndoscopy")!=null){
		opdGastroEnterologyEndoscopy =(OpdGastroEnterologyEndoscopy)map.get("opdGastroEnterologyEndoscopy");
	}
	if(map.get("dischargeIcdCodeList")!=null){
		dischargeIcdCodeList = (List<DischargeIcdCode>)map.get("dischargeIcdCodeList");
	}
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());

	 System.out.println("hinId"+hinId);

	 List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	 if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>) map.get("employeeList");
		}
%>


<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="gastroEnterologyEndoscopy" action="" method="post"><input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>" /> <%if(visit.getDepartment()!= null){ %>
<div class="floatLeft">
<h6>Gastro Enterology Endoscopy</h6>
</div>
<div class="Clear"></div>
<%} %> <!--Block One Starts-->
<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label> <%if(visit.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">
Serv. Status </label> <%if(visit.getHin().getServiceStatus()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(patientName != null){ %> <label
	class="value"><%=patientName %></label> <%}else{ %> <label class="value">-</label>
<%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(visit.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(visit.getHin().getUnit()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(visit.getHin().getUnit()!= null){%>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>


<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> 
<label style="padding-left:10px;width:150px; ">Patient Name. </label> 
<%if(patientName!= null){ %> 
<label style="padding-left:10px;width:150px;color:#000000;font:normal 11px/20px Verdana, Arial, Helvetica, sans-serif; "><%=patientName %></label> 
<%}else{ %> 
<label class="valuemedium">- </label> 
<%} %> 
<label class="medium">Age</label> 
<%if(visit.getHin().getAge()!= null){ %> 
<label class="valuemedium"><%=visit.getHin().getAge() %></label> 
<%}else{ %> 
<label class="valuemedium">-</label> <%} %> 

<div class="Clear"></div>
<label class="medium">Visit Date </label> 
<%if(visitDateInString != null){ %> 
<label class="valuemedium"><%=visitDateInString %></label>
<%}else{ %> 
<label class="valuemedium">-</label> 
<%} %>


<label class="medium">Visit no. </label> <%if(visit.getVisitNo()!= null){ %>
<label class="valuemedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Token
No. </label> <%if(visit.getTokenNo()!= null){ %> <label class="valuemedium"><%=visit.getTokenNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %> 

<div class="Clear"></div>
<label	class="medium">ECHS No. </label> <%if(visit.getHin().getEchsNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getEchsNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %>
<label >Phone Number</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %> 
<label>Mobile Number</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<!--Block one Ends--> 
<!--Block Two Starts-->
<div class="blockTitle">Service Personnel Other Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<%
			String reportNo = "";
			if(map.get("reportNo") != null){
				reportNo = (String)map.get("reportNo");
			}

		%> <label class="common">Report No </label> <label></label> <input
	type="text" value="<%=reportNo%>" name="<%=REPORT_NO %>"
	readonly="readonly" /> <label class="common">Report Date </label> <label></label>
<label class="valueNoWidth"><%=date %></label>

<div class="Clear"></div>
<%if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getId()!=null){ %>
<input type="hidden" value="<%=opdGastroEnterologyEndoscopy.getId()%>" name="opdGastroEnterologyEndoscopyId" />
<%}else{ %>
<input type="hidden" value="0" name="opdGastroEnterologyEndoscopyId" />
<%} %>
<label class="common">Refered By</label> <label></label> <select id="b1"
	name="<%=EMPLOYEE_ID %>" validate="Refered By,string,no">
	<option value="0">Select</option>
	<%
	for (MasEmployee masEmployee : employeeList) {
		if(opdGastroEnterologyEndoscopy!=null && masEmployee.getId().equals(opdGastroEnterologyEndoscopy.getReferredBy().getId())){
	%>
	<option value="<%=masEmployee.getId() %>" selected="selected"><%=masEmployee.getFirstName()+ masEmployee.getMiddleName()+ masEmployee.getLastName()%></option>
	<%}else{%>
	<option value="<%=masEmployee.getId() %>" ><%=masEmployee.getFirstName()+ masEmployee.getMiddleName()+ masEmployee.getLastName()%></option>
	<%}} %>
</select> <label class="common">Diagnosis</label> <label></label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>

<label class="common">Esophagus</label>
<%if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getEsophagus()!=null){ %>
<input	type="text" value="<%=opdGastroEnterologyEndoscopy.getEsophagus() %>"  class="large" name="<%=ESOPHAGUS %>" id="b2"	maxlength="30" />
<%}else{ %>
<input	type="text" value="Normal"  class="large" name="<%=ESOPHAGUS %>" id="b2"	maxlength="30" />
<%} %>
<div class="Clear"></div>

<label class="common">Stomach</label>
<%if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getStomach()!=null){ %>
<input type="text"	value="<%=opdGastroEnterologyEndoscopy.getStomach() %>" class="large" name="<%=STOMACH %>" id="b3"	maxlength="30" />
<%}else{ %>
<input type="text"	value="Normal" class="large" name="<%=STOMACH %>" id="b3"	maxlength="30" />
<%} %>
<div class="Clear"></div>

<label class="common">Duodenum</label>
<%if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getDuodenum()!=null){ %>
<input type="text" value="<%=opdGastroEnterologyEndoscopy.getDuodenum() %>" class="large" name="<%=DUODENUM %>" id="b4" maxlength="30" />
<%}else{ %>
<input type="text" value="Normal" class="large" name="<%=DUODENUM %>" id="b4" maxlength="30" />
<%} %>
<div class="Clear"></div>

<label class="common">Biopsy</label>
<%if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getBiopsy()!=null){ %>
<input type="text" value="<%=opdGastroEnterologyEndoscopy.getBiopsy() %>" class="large" name="<%=BIOPSY %>" id="b5" maxlength="30" />
<%}else{ %>
<input type="text" value="" class="large" name="<%=BIOPSY %>" id="b5" maxlength="30" />
<%} %>
<div class="Clear"></div>

<label class="common">Gastric antum for H Pylori</label><label></label>
<select id="b6" name="<%=GASTRIC_ANTUM_FOR_H_PYLORI %>">
<%if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getGastricAntumForHpylori().equals("0")){ %>
	<option value="0" selected="selected">Select one</option>
<%}else{%>	
	<option value="0" >Select one</option>
<%}if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getGastricAntumForHpylori().equals("RUT")){ %>	
	<option value="RUT" selected="selected">RUT</option>
<%}else{ %>	
	<option value="RUT">RUT</option>
<%}if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getGastricAntumForHpylori().equals("HPE")){ %>	
	<option value="HPE" selected="selected">HPE</option>
<%}else{ %>	
	<option value="HPE">HPE</option>
<%} %>	
</select>
<div class="Clear"></div>

<label class="common">Other/Remarks</label>
<%if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getOthersRemarks()!=null){ %>
<input	type="text" value="<%=opdGastroEnterologyEndoscopy.getOthersRemarks() %>" class="large" name="<%=OTHERS_REMARKS %>" id="b7"	maxlength="30" />
<%}else{ %>
<input	type="text" value="" class="large" name="<%=OTHERS_REMARKS %>" id="b7"	maxlength="30" />
<%} %>
<div class="Clear"></div>
<!-- -
<label class="common">Final diagnosis</label><label></label> <input
	type="text" value="" class="large" name="<%=FINAL_DIAGNOSIS %>" id="b8"	maxlength="30" />
	-->
<label>Icd Code :</label> 
<input name="" value=""	id="icdCode" tabindex="1" onblur="getIcd();" /> 
<input name="" value="" id="temp" type="hidden" /> 
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor: pointer;" class="floatLeft" onClick="javascript:openPopupWindow();" title="Click here to Search ICD Codes" /> 
<input type="hidden" name="ageName" value="<%=visit.getHin().getAge() %>" id="ageId" />	
<label>Working Diag</label>
<%if(opdGastroEnterologyEndoscopy !=null && opdGastroEnterologyEndoscopy.getFinalDiagnosis()!=null){ %>
<input type="text" id="initialDiagnosis" value="<%=opdGastroEnterologyEndoscopy.getFinalDiagnosis()%>" tabindex="1" class="large" name="<%=FINAL_DIAGNOSIS %>" maxlength="100" />
<%}else{ %>
<input type="text" id="initialDiagnosis" tabindex="1" class="large" name="<%=FINAL_DIAGNOSIS %>" maxlength="100" />
<%} %>
<div class="Clear"></div>
<label class="common">Diagnosis </label> 
<input type="text" tabindex="1" value="" id="icd" class="large" name="icd" onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update" style="display: none; padding-right: 10px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		   document.getElementById('slide0').style.display="hide"
</script> 
<select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5" tabindex="1" id="diagnosisId" class="listBig">
	<option value="0">Select</option>
<%if(dischargeIcdCodeList!=null){
	for(DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList){
%>	
<option value="<%=dischargeIcdCode.getIcd().getIcdCode()%>"><%=dischargeIcdCode.getIcd().getIcdSubCategory().getIcdSubCategoryName()+":"+dischargeIcdCode.getIcd().getIcdName() %></option>
<%}} %>
</select>
<div class="Clear"></div>
<label class="common">Impression</label>
<%if(opdGastroEnterologyEndoscopy!=null && opdGastroEnterologyEndoscopy.getImpression()!=null ){ %>
<input type="text" value="<%=opdGastroEnterologyEndoscopy.getImpression() %>" class="large2" name="<%=IMPRESSION %>" id="impression"	maxlength="200" />
<%}else{ %>
<input type="text" value="" class="large2" name="<%=IMPRESSION %>" id="impression"	maxlength="200" />
<%} %>
</div>
<!-- End block Two  -->
<div class="Clear"></div>

<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <%System.out.println("visit.getHin().getId()"+visit.getHin().getId());%>
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>">
<div class="division"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>
<input type="button" class="button" value="Submit" onclick="submitForm('gastroEnterologyEndoscopy','opd?method=addGastroEnterologyEndoscopy','blankSpace');" align="right" /> 
<input type="button" class="button" value="View" onclick="showJSP('gastroEnterologyEndoscopy');" /> 
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="history.go(-1);return false;" align="right" /></div>

</form>
<script>
function getIcd(){
	var icdCode =document.getElementById("icdCode").value

	 if(icdCode !="")
	  {
	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }

    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	         icdString  = item.getElementsByTagName('icdString')[0];
	         document.getElementById('icd').value =icdString.childNodes[0].nodeValue
	         document.getElementById('icdCode').value="";
	         fillDiagnosisCombo(document.getElementById('icd').value);
      }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  	}
  }
  function openPopupWindow()
	{
	 var url="/hms/hms/adt?method=showICDSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	function jsSetIcdData(icd_no)
	{
	document.getElementById("icdCode").value=icd_no;
	document.getElementById("icdCode").focus();
	}
</script>
</div>

