<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdCardiologyDepartmentDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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

function patientVisitPrev()
{
	var visitNo =document.getElementById('visitNo').value;
	if(visitNo==1)
	{
		alert("Not Before Visit Number");
		return false;
	}
	return true;
	

}

function patientVisitNext()
{
	var visitId =document.getElementById('visitId').value;
	var visitIdM =document.getElementById('max').value;
	if(visitId==visitIdM)
	{
		alert("Not After Visit Number");
		return false;
	}
	return true;
	

}

</script>
<!--main content placeholder starts here-->

<div id="contentHolder">
<form name="cardiologyDepartmentDetails" method="post" action="">
<h6>Cardiology</h6>
<div class="Clear"></div>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<Visit> patientDataList = new ArrayList<Visit>();
	List<OpdCardiologyDepartmentDetails> cardiologyDepartmentDetailsList = new ArrayList<OpdCardiologyDepartmentDetails>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(map.get("patientDataList") != null){
		patientDataList=(List<Visit>)map.get("patientDataList");
	}	
	if(map.get("opdCardiologyDepartmentDetailsList") != null){
		cardiologyDepartmentDetailsList=(List<OpdCardiologyDepartmentDetails>)map.get("opdCardiologyDepartmentDetailsList");
	}	
	OpdPatientDetails opdPatientDetails=new OpdPatientDetails();
	
	List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
	
	if(map.get("opdPatientDetailsList")!=null){
		System.out.println(" opdPatientDetailsList is not null");
		opdPatientDetailsList=(List<OpdPatientDetails>)map.get("opdPatientDetailsList");
		opdPatientDetails=opdPatientDetailsList.get(0);
		System.out.println(" opdPatientDetails Id"+ opdPatientDetails.getId());
	}
	
	
	List<DischargeIcdCode> dischargeIcdCodeList=new ArrayList<DischargeIcdCode>();
	
	if(map.get("dischargeIcdCodeList")!=null){
		System.out.println(" dischargeIcdCodeList is not null");
		dischargeIcdCodeList=(List<DischargeIcdCode>)map.get("dischargeIcdCodeList");
	}
	
	List<MasDepartment> deptList= new ArrayList<MasDepartment>();
	if(map.get("deptList") != null){
	deptList=(List)map.get("deptList");
	}
	
	List<MasEmployee> doctarsList = new ArrayList<MasEmployee>();
	if(map.get("doctarsList")!=null){
		doctarsList=(List<MasEmployee>)map.get("doctarsList");
	}

	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	
	Visit visit = new Visit();
	if(patientDataList.size() > 0){
		visit = patientDataList.get(0);
	}

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
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	%> <!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label>
<input
	type="hidden" name="opdPatientDetailsId"
	value="<%=opdPatientDetails.getId() %>"> 
 <%if(visit.getHin().getServiceType()!= null){ %>
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
	class="medium">Unit</label> <%if(visit.getHin().getUnit()!= null && !visit.getHin().getUnit().getUnitName().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(visit.getHin().getUnit()!= null&& !visit.getHin().getUnit().getUnitAddress().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<label class="medium">Tel No.</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>

<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Age</label>
<%if(visit.getHin().getAge()!= null){ %> <label class="valuemedium"><%=visit.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Visit Date </label> <%if(visitDateInString != null){ %> <label
	class="valuemedium"><%=visitDateInString %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">Visit
no. </label> <%if(visit.getVisitNo()!= null){ %> <label class="valuemedium"><%=visit.getVisitNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>



<div class="Clear"></div>


<label class="medium">Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="valuemedium"><%=visit.getTokenNo() %></label> <%}else{ %> <label
	class="valuemedium">-</label> <%} %> <label class="medium">ECHS
No. </label> <%if(visit.getHin().getEchsNo()!= null){ %> <label
	class="valuemedium"><%=visit.getHin().getEchsNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Patient
Name</label> <%if(patientName!= null){ %> <label class="value"><%=patientName %>
</label> <%}else{ %> <label class="value">- </label> <%} %> <label class="medium">Prev.
Diag </label> <%if(visit.getDiagnosis()!= null){ %> <label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="valueNoWidth">-</label> <%} %>

<div class="Clear"></div>

</div>


<!--Block one Ends--> <%if(cardiologyDepartmentDetailsList.size() > 0){
    	
    	OpdCardiologyDepartmentDetails cardiologyDepartmentDetails = new OpdCardiologyDepartmentDetails();
    	cardiologyDepartmentDetails = cardiologyDepartmentDetailsList.get(0);
    	 %>
<div class="Clear"></div>
<div class="division"></div>

<div class="colA">

<div class="title">Diagnosis</div>
<div class="Clear"></div>
<!-- 	<label class="small">On Examination</label>  --> <input
	type="hidden" id="onExamination" class="large" name="onExamination"
	maxlength="200" />
<div class="Clear"></div>

<label class="small">Icd Code :</label> 
 <input name="" value="" id="icdCode" onblur="getIcd();" /> 
 <input name="" value="" id="temp" type="hidden" /> 
 <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" 	HEIGHT="26" style="cursor: pointer;" class="floatLeft"	onClick="javascript:openPopupWindow();"	title="Click here to Search ICD Codes" /> 
 <input type="hidden" name="ageName" value="<%=visit.getHin().getAge() %>" id="ageId" />
  <label class="small">Initial Diag</label> <%if(opdPatientDetails.getInitialDiagnosis()!=null){ %>
<input type="text" id="initialDiagnosis" class="large"
	value="<%=opdPatientDetails.getInitialDiagnosis() %>"
	name="initialDiagnosis" maxlength="100" /> <%}else{ %>
	 <input type="text" id="initialDiagnosis" class="large" name="initialDiagnosis"
	maxlength="100" /> <%} %>
<div class="Clear"></div>
<label class="small">Diagnosis </label> <input type="text" value=""
	id="icd" class="large" name="icd"
	onblur="fillDiagnosisCombo(this.value);" />
<div id="ac2update"
	style="display: none; padding-right: 10px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update','opd?method=getICDList',{parameters:'requiredField=icd'});
		</script> <select name="<%=DIAGNOSIS_ID%>" multiple="4" size="5"
	id="diagnosisId"  class="listBig">
	<option value="0">Select</option>
	<%for(DischargeIcdCode dischargeIcdCode:dischargeIcdCodeList){ %>
	<option value="<%=dischargeIcdCode.getIcd().getIcdCode()%>"><%=dischargeIcdCode.getIcd().getIcdName()%>[<%=dischargeIcdCode.getIcd().getIcdCode()%>]</option>
	<%} %>
</select>

<input type="button" class="button" value="Delete"
  	onclick="deleteDgItems(this,'diagnosisId');" align="right" />


<div class="Clear"></div>

</div>

<label class="common">TMT Report</label> <label class="common"></label>
<textarea maxlength="40" onkeyup="return ismaxlength(this)" rows=""
	cols="" name="<%=TMT_REPORT %>" id="b1"><%=cardiologyDepartmentDetails.getTmtReport() %></textarea>
<div class="Clear"></div>

<label class="common">Echo cardiology</label> <label class="common"></label>

<textarea maxlength="40" onkeyup="return ismaxlength(this)" rows=""
	cols="" name="<%=ECHO_CARDIOLOGY %>" id="b2"><%=cardiologyDepartmentDetails.getEchoCardiology() %></textarea>


<div class="Clear"></div>

<label class="common">Holter</label> <label class="common"></label> <textarea
	maxlength="40" onkeyup="return ismaxlength(this)" rows="" cols=""
	name="<%=HOLTER %>" id="b3"><%=cardiologyDepartmentDetails.getHolter() %></textarea>


<div class="Clear"></div>

<label class="common">Cardiac Cathetization Data</label> <label
	class="common"></label> <textarea maxlength="40"
	onkeyup="return ismaxlength(this)" rows="" cols=""
	name="<%=CARDIAC_CATHETIZATION_DATA %>" id="b4"><%=cardiologyDepartmentDetails.getCardiacCathetizationData() %></textarea>


<div class="Clear"></div>

<label class="common">Remarks</label> <label class="common"></label> <textarea
	maxlength="40" onkeyup="return ismaxlength(this)" rows="" cols=""
	name="<%=REMARKS %>" id="b5"><%=cardiologyDepartmentDetails.getRemarks() %></textarea>


<div class="Clear"></div>
<div class="division"></div>

<!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>
<input name="prev" type="button" class="button" value="Update"
	onclick="submitForm('cardiologyDepartmentDetails','opd?method=updateCardiologyDepartmentDetails');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('cardiologyDepartmentDetails','opd?method=showCardiologyDepartmentDetailsJsp&visitId=<%=currentVisitId%>');"
	align="right" /></div>
<%}%> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="cardiologyId" id="cardiologyId"
	value="<%=cardiologyDepartmentDetails.getId()%>"> <input
	type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden" id="max"
	name="currentVisitId" value="<%=currentVisitId %>"> <input
	type="hidden" name="visitId" id="visitId" value="<%=visit.getId() %>">
<%}else{%> <label><span>No Record Found!!</span></label>
<div class="Clear"></div>
<div class="bottom"><input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="currentVisitId" name="currentVisitId"
	value="<%=currentVisitId %>"> <input type="hidden" id="visitId"
	value="<%=visit.getId() %>"> <input type="hidden" id="max"
	name="max" value="<%=max %>"> <input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('cardiologyDepartmentDetails','opd?method=viewCardiologyDepartmentDetails&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('cardiologyDepartmentDetails','opd?method=viewCardiologyDepartmentDetails&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('cardiologyDepartmentDetails','opd?method=showCardiologyDepartmentDetailsJsp&visitId=<%=currentVisitId%>');"
	align="right" /></div>


<%} %>

</div>
<!--Bottom labels ends-->

<div class="division"></div>
</form>
</div>
<script type="text/javascript">
function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}

	function openPopupWindow()
	{
	 var url="/hms/hms/adt?method=showICDSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}

//=========To get Icd String with icd code==========================
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
      }
      }
      }
    var url="/hms/hms/adt?method=getIcdWithIcdCodeForOpd&icdCode="+encodeURIComponent(icdCode)
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  	}
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

  function deleteDgItems(value){
     if(document.getElementById('diagnosisId').selectedIndex!=0){
	 if(confirm("are you sure want to delete ?")){

 	 		document.getElementById('diagnosisId').remove(document.getElementById('diagnosisId').selectedIndex)

	    }
	   }
     }

</script>

