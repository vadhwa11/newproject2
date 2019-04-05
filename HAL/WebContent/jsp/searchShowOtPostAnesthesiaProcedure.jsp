<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>

<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
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
<%--For AutoComplete Through Ajax--%>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showPostAnaesthesiaPatientDetails";
  obj.submit();
}
</script>
<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}

	%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>




<%

		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}


		 List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		 if(map.get("anesthesiaList") != null){
			 anesthesiaList = (List<MasAnesthesia>) map.get("anesthesiaList");
			}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	 //List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();


	//if(map.get("patientDetailList") != null){

	//	patientDetailList=(List)map.get("patientDetailList");

	//}
	if(map.get("departmentList") != null){

		departmentList=(List)map.get("departmentList");

	}
	OtBooking otbook = new OtBooking();

	//if(patientDetailList.size() > 0 && patientDetailList!= null){
	//for (Iterator iter1 = patientDetailList.iterator(); iter1.hasNext();) {


	List<OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedureList = new ArrayList<OtPostAnaesthesiaProcedure>();
	if(map.get("otPostAnaesthesiaProcedureList") != null){
		otPostAnaesthesiaProcedureList=(List<OtPostAnaesthesiaProcedure>)map.get("otPostAnaesthesiaProcedureList");

	}
	if(otPostAnaesthesiaProcedureList.size() > 0 && otPostAnaesthesiaProcedureList!= null){
		otbook = otPostAnaesthesiaProcedureList.get(0).getOtBooking();
		for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter.hasNext();) {
			OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter.next();


		List<OtSurgeyPaEmployeeDetail> surgeyPaEmployeeDetailList = new ArrayList<OtSurgeyPaEmployeeDetail>();
		if(map.get("surgeyPaEmployeeDetailList") != null){
			surgeyPaEmployeeDetailList=(List<OtSurgeyPaEmployeeDetail>)map.get("surgeyPaEmployeeDetailList");
		}
		List<OtSurgeyPaSurgeyDetail> surgeyPaSurgeyDetailList = new ArrayList<OtSurgeyPaSurgeyDetail>();
		if(map.get("surgeyPaSurgeyDetailList") != null){
			surgeyPaSurgeyDetailList=(List<OtSurgeyPaSurgeyDetail>)map.get("surgeyPaSurgeyDetailList");
		}
		List<OtSurgeyPaAnesthesiologistDetail> surgeyPaAnesthesiologistDetailList = new ArrayList<OtSurgeyPaAnesthesiologistDetail>();
		if(map.get("surgeyPaAnesthesiologistDetailList") != null){
			surgeyPaAnesthesiologistDetailList=(List<OtSurgeyPaAnesthesiologistDetail>)map.get("surgeyPaAnesthesiologistDetailList");
		}
		List<OtSurgeyPaIvFluidsDetail> surgeyPaIvFluidsDetailList = new ArrayList<OtSurgeyPaIvFluidsDetail>();
		if(map.get("surgeyPaIvFluidsDetailList") != null){
			surgeyPaIvFluidsDetailList=(List<OtSurgeyPaIvFluidsDetail>)map.get("surgeyPaIvFluidsDetailList");
		}
		List<OtSurgeyPaPremedicationDetail> surgeyPaPremedicationDetailList = new ArrayList<OtSurgeyPaPremedicationDetail>();
		if(map.get("surgeyPaPremedicationDetailList") != null){
			surgeyPaPremedicationDetailList=(List<OtSurgeyPaPremedicationDetail>)map.get("surgeyPaPremedicationDetailList");
		}
		List<OtSurgeyPaProcedureDetail> surgeyPaProcedureDetailList = new ArrayList<OtSurgeyPaProcedureDetail>();
		if(map.get("surgeyPaProcedureDetailList") != null){
			surgeyPaProcedureDetailList=(List<OtSurgeyPaProcedureDetail>)map.get("surgeyPaProcedureDetailList");
		}



	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	String patientName="";
	if(otPostAnaesthesiaProcedure.getHin().getPFirstName()!= null){
		patientName=otPostAnaesthesiaProcedure.getHin().getPFirstName();
	}
	if(otPostAnaesthesiaProcedure.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+otPostAnaesthesiaProcedure.getHin().getPMiddleName();
	}
	if(otPostAnaesthesiaProcedure.getHin().getPLastName()!= null){
		patientName=patientName+" "+otPostAnaesthesiaProcedure.getHin().getPLastName();
	}
	String servicePersonName="";
	if(otPostAnaesthesiaProcedure.getHin().getSFirstName()!= null){
		servicePersonName=otPostAnaesthesiaProcedure.getHin().getSFirstName();
	}
	if(otPostAnaesthesiaProcedure.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+otPostAnaesthesiaProcedure.getHin().getSMiddleName();
	}
	if(otPostAnaesthesiaProcedure.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+otPostAnaesthesiaProcedure.getHin().getSLastName();
	}

%>
<script type="text/javascript">
function get_valueForPACDeatil(orderNo,hinId,visitInpatientID,flag)
{

	if(flag == 'v'){
   		var url="/hms/hms/ot?method=showPACDetailJsp&orderNo=<%=otbook.getOrderNo()%>&hinId=<%=otbook.getHin().getId()%>&visitId="+visitInpatientID;
	}else if(flag == 'i'){
   		var url="/hms/hms/ot?method=showPACDetailJsp&orderNo=<%=otbook.getOrderNo()%>&hinId=<%=otbook.getHin().getId()%>&inpatientId="+visitInpatientID;
   	}
   	popwindowGravidagram(url);
}


 function popwindowGravidagram(url)
{
 window.location.href = url;
 //newwindow=window.open(url,"name","left=100,top=100,height=1000,width=1000,status=1,scrollbars=1,resizable=0");
// if (window.focus)
 //{
 //	newwindow.focus()
 //}
//newwindow.createPopup();
 //window.close();
}
	function submitFormForPACPreview(orderNo){
		submitForm('postAnesthesiaProcedure','/hms/hms/ot?method=printPAC&orderNo='+orderNo,'checkTargetForYes');
		checkTargetForNo();
	}

</script>






<div id="contentHolder">
<form name="postAnesthesiaProcedure" action="" method="post">



<h6>Post OP Notes (Anaesthesia)</h6>
<div class="Clear"></div>
<div class="header"><label>Yearly Serial No</label> <label
	class="value"><input type="text"
	value="<%=otPostAnaesthesiaProcedure.getYearlySlNo() %>"
	name="yearlySlNo" /></label> <label class="valuemedium">Monthly Serial
No</label> <label class="value"><input type="text"
	value="<%=otPostAnaesthesiaProcedure.getMonthlySlNo() %>"
	name="monthlySlNo" /> </label> <label class="valuemedium">Date</label> <input
	type="text" id="startDateId" name="<%=START_DATE%>"
	value="<%=HMSUtil.changeDateToddMMyyyy(otPostAnaesthesiaProcedure.getDateOfPost()) %>"
	class="textbox_date" readonly="readonly" validate="Date,date,yes"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.postAnesthesiaProcedure.<%=START_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a></div>
<div class="Clear"></div>
<!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%if(otPostAnaesthesiaProcedure.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(otPostAnaesthesiaProcedure.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getServiceNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium"> Serv. Status </label> <%if(otPostAnaesthesiaProcedure.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(servicePersonName != null){ %> <label
	class="valuemedium" style="width: auto;"><%=servicePersonName %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(otPostAnaesthesiaProcedure.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(otPostAnaesthesiaProcedure.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(otPostAnaesthesiaProcedure.getHin().getUnit()!= null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">--</label> <%} %> <label
	class="medium">Unit Address</label> <% if(otPostAnaesthesiaProcedure.getHin().getUnit()!= null){%>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">--</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(otPostAnaesthesiaProcedure.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getHinNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Patient Name. </label> <%if(patientName!= null){ %> <label
	class="valuemedium"><%=patientName %> </label> <%}else{ %> <label
	class="valuemedium">- </label> <%} %> <label class="medium">Age</label> <%if(otPostAnaesthesiaProcedure.getHin().getAge()!= null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Patient Status </label> <%if(otPostAnaesthesiaProcedure.getHin().getPatientStatus() != null){ %>
<label class="valuemedium"><%=otPostAnaesthesiaProcedure.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Reg.Date </label> <%if(otPostAnaesthesiaProcedure.getHin().getRegDate()!= null){ %>
<label class="valuemedium"><%=HMSUtil.changeDateToddMMyyyy(otPostAnaesthesiaProcedure.getHin().getRegDate()) %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>

<div class="Clear"></div>


</div>
<div class="division"></div>
<div class="Clear"></div>
<h5>PAC Details</h5>

<%if(otbook.getVisit() != null){ %> <input tabindex="2" name="PAC Preview"
	type="button" value="PAC Preview"
	onclick="submitFormForPACPreview('<%=otbook.getOrderNo()%>');"
	class="cmnButton" /> <% }else if(otbook.getInpatient() != null){ %> <input
	tabindex="2" name="PAC Preview" type="button" value="PAC Preview"
	onclick="submitFormForPACPreview('<%=otbook.getOrderNo()%>');" /> <% } %>
<div class="division"></div>

<div class="Clear"></div>
<h5>Procedure</h5>

<div class="Clear"></div>
<div class="tableHolderAuto"><label class="noWidth">Surgery
Name</label> <input tabindex="2" name="Add" type="button" class="cmnButton"
	value="Add" onclick="addRowForInvestigation();" /> <input tabindex="2"
	name="Delete" type="button" class="cmnButton" value="Delete"
	onclick="removeRowForInvestigation();" />


<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="investigationGrid">
	<tr>

		<th scope="col">Surgery Name</th>
		<!--  <th scope="col">Surgery Code</th> -->

	</tr>
	<%
	    int q=1;
	    	Iterator surgeyPaSurgeyDetailItr= surgeyPaSurgeyDetailList.iterator();
	    	while(surgeyPaSurgeyDetailItr.hasNext())
	    	{
	    		OtSurgeyPaSurgeyDetail surgeyPaSurgeyDetail=(OtSurgeyPaSurgeyDetail)surgeyPaSurgeyDetailItr.next();

	    %>
	<tr>


		<td><input type="text" name="chargeCodeName<%=q %>"
			id="chargeCodeName<%=q %>"
			value="<%=surgeyPaSurgeyDetail.getChargeCode().getChargeCodeName()%>[<%=surgeyPaSurgeyDetail.getChargeCode().getId()%>]"
			size="43" readonly="readonly"/>
		<div id="ac2update6"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>

		</td>


		<input type="hidden" name="chargeCode<%=q %>" id="chargeCode<%=q %>"
			value="<%=surgeyPaSurgeyDetail.getChargeCode().getChargeCodeCode() %>"
			size="10" />


	</tr>
	<%
	   q++;	}
	  %>
	<tr>


		<td><input type="text" value="" tabindex="2"
			id="chargeCodeName<%=q%>" size="43" name="chargeCodeName<%=q%>" />
		<div id="ac2update6"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>

		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=q%>','ac2update6','ot?method=getSurgeyForAutoComplete',{parameters:'requiredField=chargeCodeName<%=q%>'});
				</script></td>

		<!--  <td id="chargeCodeVal"> -->
		<input type="hidden" id="chargeCode<%=q%>" name="chargeCode<%=q%>"
			size="10" tabindex="2" />
		<!--   </td> -->


	</tr>
	<input type="hidden" value="<%=q%>" name="hiddenValue" id="hiddenValue" />

</table>

<div class="Clear"></div>
<div class="Height10"></div>
<label class="noWidth">Surgeon's Name</label> <input tabindex="2"
	name="AddSurgeon" type="button" class="cmnButton" value="Add"
	onclick="addRowForSurgeon();" /> <input tabindex="2"
	name="DeleteSurgeon" type="button" class="cmnButton" value="Delete"
	onclick="removeRowForSurgeon();" />



<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="sergonGrid">
	<tr>

		<th scope="col">Sergeon's Name</th>

	</tr>


	<%	    int w=1;
	    	Iterator surgeyPaEmployeeDetailItr= surgeyPaEmployeeDetailList.iterator();
	    	while(surgeyPaEmployeeDetailItr.hasNext())
	    	{
	    		OtSurgeyPaEmployeeDetail surgeyPaEmployeeDetail=(OtSurgeyPaEmployeeDetail)surgeyPaEmployeeDetailItr.next();

	    		String  fullName = surgeyPaEmployeeDetail.getEmployee().getFirstName();
	    		if(surgeyPaEmployeeDetail.getEmployee().getMiddleName() != null){
	    			fullName = fullName + " " + surgeyPaEmployeeDetail.getEmployee().getMiddleName();
	    		}
	    		if(surgeyPaEmployeeDetail.getEmployee().getLastName() != null){
	    			fullName = fullName + " " + surgeyPaEmployeeDetail.getEmployee().getLastName();
	    		}


	    %>
	<tr>


		<td><input type="text" name="empNameS<%=w %>"
			id="empNameS<%=w %>"
			value="<%=fullName%>[<%=surgeyPaEmployeeDetail.getEmployee().getId()%>]"
			size="43" readonly="readonly" />
		<div id="ac2update5"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>

		</td>





	</tr>
	<%
	   w++;	}
	  %>
	<tr>




		<td><input type="text" value="" tabindex="2" id="empNameS<%=w %>"
			size="43" name="empNameS<%=w %>" />
		<div id="ac2update5"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

			  new Ajax.Autocompleter('empNameS<%=w %>','ac2update5','ot?method=getSergonForAutoComplete',{parameters:'requiredField=empNameS<%=w %>'});
			</script></td>



	</tr>
	<input type="hidden" value="<%=w %>" name="hiddenValueSergon"
		id="hiddenValueSergon" />
</table>


<div class="Clear"></div>
<label class="common">Surgery Time</label><label class="valueNoWidth">From</label>


<%if(otPostAnaesthesiaProcedure.getSurgeyFromTime() != "" && otPostAnaesthesiaProcedure.getSurgeyFromTime()!=null){ %>
<input tabindex="2" name="surgey_from_time" type="text"
	id="surgey_from_time" class="calDate" maxlength="5"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,'surgey_from_time')"
	value="<%=otPostAnaesthesiaProcedure.getSurgeyFromTime() %>" /> <%}else{ %>
<input tabindex="2" name="surgey_from_time" type="text"
	id="surgey_from_time"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,'surgey_from_time')"
	class="calDate" maxlength="5" /> <%} %> <label
	style="padding-left: 0px; margin-left: 4px; margin-right: 7px; float: left; text-align: left;">(HH:MM)</label>

<label class="valueNoWidth">To</label> <%if(otPostAnaesthesiaProcedure.getSurgeyToTime() != "" && otPostAnaesthesiaProcedure.getSurgeyToTime()!=null){ %>
<input name="surgey_to_time" tabindex="2" type="text" class="calDate"
	maxlength="5" id="surgey_to_time"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,'surgey_to_time')"
	value="<%=otPostAnaesthesiaProcedure.getSurgeyToTime() %>" /> <%}else{ %>
<input name="surgey_to_time" tabindex="2" type="text" class="calDate"
	id="surgey_to_time"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,'surgey_to_time')"
	maxlength="7" /> <%} %> <label
	style="padding-left: 0px; margin-left: 4px; margin-right: 7px; float: left; text-align: left;">(HH:MM)</label>

<label class="fixed">Anesthesia</label> <!-- 	<select id="anesthesia_id" name="anesthesia_id" validate="Anesthesia,string,no" onchange="anesthesiaCheck();" tabindex="2"> -->
<select id="anesthesia_id" name="anesthesia_id"
	validate="Anesthesia,string,no" tabindex="2">
	<option value="0">Select</option>
	<%if(anesthesiaList !=null){
	  for(MasAnesthesia masAnesthesia : anesthesiaList){
		  if(otPostAnaesthesiaProcedure.getAnesthesiaValue().equals(masAnesthesia.getAnesthesiaCode())){
	%>
	<option value="<%=masAnesthesia.getAnesthesiaCode() %>" selected="selected"> <%=masAnesthesia.getAnesthesiaCode() %> </option>
	<%}else{ %>
	<option value="<%=masAnesthesia.getAnesthesiaCode() %>"> <%=masAnesthesia.getAnesthesiaCode() %> </option>
	<%}}} %>
</select> <%
	if(otPostAnaesthesiaProcedureList.size() > 0){ %> <script
	type="text/javascript">
			document.getElementById('anesthesia_id').value = '<%=otPostAnaesthesiaProcedure.getAnesthesiaValue()%>';
		</script> <% } %>

<div class="Clear"></div>
<div class="Height10"></div>
<label class="noWidth">Anesthesiologist(s)</label> <input tabindex="2"
	name="AddA" type="button" class="cmnButton" value="Add"
	onclick="addRowForAnesthesiologist();" /> <input tabindex="2"
	name="DeleteA" type="button" class="cmnButton" value="Delete"
	onclick="removeRowForAnesthesiologist();" />


<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="anesthesiologistGrid">
	<tr>

		<th scope="col">Anesthesiologist's Name</th>
	</tr>
	<%
	    int u=1;
	    	Iterator surgeyPaAnesthesiologistDetailItr= surgeyPaAnesthesiologistDetailList.iterator();
	    	while(surgeyPaAnesthesiologistDetailItr.hasNext())
	    	{
	    		OtSurgeyPaAnesthesiologistDetail surgeyPaAnesthesiologistDetail=(OtSurgeyPaAnesthesiologistDetail)surgeyPaAnesthesiologistDetailItr.next();

	    		String  fullName = surgeyPaAnesthesiologistDetail.getEmployee().getFirstName();
	    		if(surgeyPaAnesthesiologistDetail.getEmployee().getMiddleName() != null){
	    			fullName = fullName + " " + surgeyPaAnesthesiologistDetail.getEmployee().getMiddleName();
	    		}
	    		if(surgeyPaAnesthesiologistDetail.getEmployee().getLastName() != null){
	    			fullName = fullName + " " + surgeyPaAnesthesiologistDetail.getEmployee().getLastName();
	    		}
	    		%>
	<tr>


		<td><input type="text" name="empName<%=u %>" id="empName<%=u %>"
			value="<%=fullName%>[<%=surgeyPaAnesthesiologistDetail.getEmployee().getId()%>]"
			size="43" readonly="readonly"/>
		<div id="ac2update4"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>

		</td>

	</tr>
	<%
	   u++;	}
	  %>
	<tr>

		<td><input type="text" value="" tabindex="2" id="empName<%=u %>"
			size="43" name="empName<%=u %>" />
		<div id="ac2update4"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

			  new Ajax.Autocompleter('empName<%=u %>','ac2update4','ot?method=getAnesthesiologistForAutoComplete',{parameters:'requiredField=empName<%=u %>'});
			</script></td>


	</tr>
	<input type="hidden" value="<%=u %>" name="hiddenValueAnesthesiologist"
		id="hiddenValueAnesthesiologist" />

</table>
<div class="Clear"></div>
<label class="common">Anesthesia Time</label><label class="valueNoWidth">From</label>
<%if(otPostAnaesthesiaProcedure.getAnaesthesiaFromTime() != "" && otPostAnaesthesiaProcedure.getAnaesthesiaFromTime()!=null){ %>

<input tabindex="2" name="anaesthesia_from_time" type="text"
	id="anaesthesia_from_time"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,'anaesthesia_from_time')"
	class="calDate" maxlength="5"
	value="<%=otPostAnaesthesiaProcedure.getAnaesthesiaFromTime() %>" /> <%}else{ %>
<input tabindex="2" name="anaesthesia_from_time" type="text"
	id="anaesthesia_from_time"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,'anaesthesia_from_time')"
	class="calDate" maxlength="5" /> <%} %> <label
	style="padding-left: 0px; margin-left: 4px; margin-right: 7px; float: left; text-align: left;">(HH:MM)</label>


<label class="valueNoWidth">To</label> <%if(otPostAnaesthesiaProcedure.getAnaesthesiaToTime() != "" && otPostAnaesthesiaProcedure.getAnaesthesiaToTime()!=null){ %>
<input name="anaesthesia_to_time" tabindex="2" type="text"
	class="calDate" id="anaesthesia_to_time"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,'anaesthesia_to_time')"
	maxlength="5"
	value="<%=otPostAnaesthesiaProcedure.getAnaesthesiaToTime() %>" /> <%}else{ %>
<input name="anaesthesia_to_time" tabindex="2"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	id="anaesthesia_to_time"
	onblur="IsValidTimeWithBlankCheck(this.value,'anaesthesia_to_time')"
	type="text" class="calDate" maxlength="5" /> <%} %> <label
	style="padding-left: 0px; margin-left: 4px; margin-right: 7px; float: left; text-align: left;">(HH:MM)</label>


<div class="Clear"></div>
<div class="Height10"></div>


<label class="noWidth">Premedication/ Induction </label> <input
	name="Add2" type="button" class="cmnButton" value="Add"
	onclick="addRowForPremedication();" tabindex="2" /> <input
	name="Delete" type="button" class="cmnButton" value="Delete"
	onclick="removeRowForPremedication();" tabindex="2" />

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="premedicationGrid">
	<tr>
		<th scope="col">Type</th>
		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS/ NIV No.</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
	</tr>

	<%
	    int i=1;
	    	Iterator surgeyPaPremedicationDetailItr= surgeyPaPremedicationDetailList.iterator();
	    	while(surgeyPaPremedicationDetailItr.hasNext())
	    	{
	    		OtSurgeyPaPremedicationDetail surgeyPaPremedicationDetail = (OtSurgeyPaPremedicationDetail)surgeyPaPremedicationDetailItr.next();
	    %>
	<tr>
		<td>
		<%if(surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType()!= "p" && surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType().equals("p"))
	 { %> <input type="text" name="typePIMToShow<%=i %>"
			id="typePIMToShow<%=i %>" value="Premedication" /> <input
			type="hidden" name="typePIM<%=i %>" id="typePIM<%=i %>" value="p" />
		<%}else if(surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType()!= "i" && surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType().equals("i")){ %>
		<input type="text" name="typePIMToShow<%=i %>"
			id="typePIMToShow<%=i %>" value="Induction" /> <input type="hidden"
			name="typePIM<%=i %>" id="typePIM<%=i %>" value="i" /> <%}else if(surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType()!= "m" && surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType().equals("m")){ %>
		<input type="text" name="typePIMToShow<%=i %>"
			id="typePIMToShow<%=i %>" value="Maintenance" /> <input
			type="hidden" name="typePIM<%=i %>" id="typePIM<%=i %>" value="m" />
		<%}else{ %> <input type="text" name="typePIMToShow<%=i %>"
			id="typePIMToShow<%=i %>" value="-" /> <input type="hidden"
			name="typePIM<%=i %>" id="typePIM<%=i %>" value="-" /> <%} %>
		</td>
		<td><input type="text" name="nomenclaturePr<%=i %>"
			id="nomenclaturePr<%=i %>"
			value="<%=surgeyPaPremedicationDetail.getItem().getNomenclature()%>[<%=surgeyPaPremedicationDetail.getItem().getPvmsNo()%>]"
			size="43" readonly="readonly" />
		<div id="ac2update3"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>

		</td>

		<td><input type="text" name="pvmsNoPr<%=i %>"
			id="pvmsNoPr<%=i %>"
			value="<%=surgeyPaPremedicationDetail.getItem().getPvmsNo() %>"
			size="10" readonly="readonly" /></td>


		<td><input type="text" name="dv<%=i %>" id="dv<%=i %>"
			value="<%=surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailDosa() %>"
			size="10" readonly="readonly"/></td>

		<td><input type="text" name="route<%=i %>" id="route<%=i %>"
			value="<%=surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailRoute() %>"
			size="10" readonly="readonly" /></td>
	</tr>
	<%
	   i++;	}
	  %>
	<tr>
		<td><select name="typePIM<%=i %>" id="typePIM<%=i %>"
			tabindex="2">
			<option value="">Select</option>
			<option value="p">Premedication</option>
			<option value="i">Induction</option>

		</select></td>
		<td><input type="text" value="" tabindex="2"
			id="nomenclaturePr<%=i %>" size="43" name="nomenclaturePr<%=i %>"
			onblur="populatePVMSPr1(this.value,'<%=i %>')" />
		<div id="ac2update3"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclaturePr<%=i %>','ac2update3','ot?method=getItemPrListForAutoComplete',{parameters:'requiredField=nomenclaturePr<%=i %>'});
			</script></td>
		<td><input type="text" name="pvmsNoPr<%=i %>"
			id="pvmsNoPr<%=i %>" size="10" /></td>



		<td><input type="text" size="10" id="dv<%=i %>" name="dv<%=i %>"
			maxlength="20" tabindex="2" /></td>


		<td><select name="route<%=i %>" id="route<%=i %>" tabindex="2">
			<option value="">Select</option>
			<option value="1/V">1/V</option>
			<option value="1/M">1/M</option>
			<option value="Oral">Oral</option>
			<option value="S.C.">S.C.</option>
		</select></td>
	</tr>

	<input type="hidden" value="<%=i %>" name="hiddenValuePremedication"
		id="hiddenValuePremedication" />

</table>


<div class="Clear"></div>
<div class="Height10"></div>
<label class="noWidth">Procedure Details </label> <input name="AddP"
	type="button" class="cmnButton" value="Add"
	onclick="addRowForProcedure();" tabindex="2" /> <input name="DeleteP"
	type="button" class="cmnButton" value="Delete"
	onclick="removeRowForProcedure();" tabindex="2" />

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="procedureGrid">
	<tr>
		<th scope="col">Anesthesia</th>
		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS/ NIV No.</th>
		<th scope="col">Dose</th>
		<th scope="col">level</th>
		<th scope="col">Catheter</th>
	</tr>



	<%
	    int x=1;
	    	Iterator surgeyPaProcedureDetailItr= surgeyPaProcedureDetailList.iterator();
	    	while(surgeyPaProcedureDetailItr.hasNext())
	    	{
	    		OtSurgeyPaProcedureDetail surgeyPaProcedureDetail=(OtSurgeyPaProcedureDetail)surgeyPaProcedureDetailItr.next();



	    %>
	<tr>


		<td><input type="text" name="anesthesia<%=x %>"
			id="anesthesia<%=x %>"
			value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailAnesthesia() %>" readonly="readonly"/>
		</td>
		<td><input type="text" name="nomenclatureP<%=x %>"
			id="nomenclatureP<%=x %>"
			value="<%=surgeyPaProcedureDetail.getItem().getNomenclature()%>[<%=surgeyPaProcedureDetail.getItem().getPvmsNo()%>]"
			size="43" readonly="readonly" />
		<div id="ac2update2"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>

		</td>

		<td><input type="text" name="pvmsNoP<%=x %>" id="pvmsNoP<%=x %>"
			value="<%=surgeyPaProcedureDetail.getItem().getPvmsNo()%>" size="10" readonly="readonly"/>
		</td>


		<td><input type="text" name="d<%=x %>" id="d<%=x %>"
			value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailDosa() %>"
			size="10" readonly="readonly" /></td>

		<td><input type="text" name="level<%=x %>" id="level<%=x %>"
			value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailLevel() %>"
			size="10" readonly="readonly" /></td>
		<td><input type="text" name="c<%=x %>" id="c<%=x %>"
			value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailCatheter() %>"
			size="10" readonly="readonly" /></td>

	</tr>
	<%
	   x++;	}
	  %>

	<tr>

		<!--  <% //if(otPostAnaesthesiaProcedure.getAnesthesia()==null){ %> -->
		<!--  <td id="s1"> -  </td> -->
		<!--  <%//}else{ %> -->

		<td id="s2"><!--   <select name="anesthesia<%=x %>" id="anesthesia<%=x %>" tabindex="2" onchange="anesthesiaCobom();" > -->
		<select name="anesthesia<%=x %>" id="anesthesia<%=x %>" tabindex="2">
			<option value="">Select</option>
			<%if(anesthesiaList !=null){
	   				for(MasAnesthesia masAnesthesia : anesthesiaList){
			%>
			<option value="<%=masAnesthesia.getAnesthesiaCode() %>"> <%=masAnesthesia.getAnesthesiaCode() %> </option>
			<%}} %>
		</select></td>
		<!--  <%//}%> -->
		<td><input type="text" value="" tabindex="2"
			id="nomenclatureP<%=x %>" size="43" name="nomenclatureP<%=x %>"
			onblur="populatePVMSP1(this.value,'<%=x %>')" />
		<div id="ac2update2"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclatureP<%=x %>','ac2update2','ot?method=getItemPListForAutoComplete',{parameters:'requiredField=nomenclatureP<%=x %>'});
			</script></td>
		<td><input type="text" name="pvmsNoP<%=x %>" id="pvmsNoP<%=x %>"
			size="10" /></td>



		<td><input type="text" size="10" id="d<%=x %>" name="d<%=x %>"
			maxlength="20" tabindex="2" /></td>

		<!--  <td id="s3"> -  </td> -->
		<td id="s4" style="display: block;"><select name="level<%=x %>"
			id="level<%=x %>" tabindex="2">
			<option value="">Select</option>
			<option value="L1-2">L1-2</option>
			<option value="L2-3">L2-3</option>
			<option value="L3-L4">L3-L4</option>

		</select></td>


		<td id="s5" style="display: none;"><select name="level<%=x %>"
			id="level<%=x %>" tabindex="2">
			<option value="">Select</option>
			<option value="T1-2">T1-2</option>
			<option value="T2-3">T2-3</option>
			<option value="T3-4">T3-4</option>
			<option value="T4-5">T4-5</option>
			<option value="T5-6">T5-6</option>
			<option value="T6-7">T6-7</option>
			<option value="T8-L1">T8-L1</option>
			<option value="L1-L2">L1-L2</option>
			<option value="L2-L3">L2-L3</option>
			<option value="L3-L4">L3-L4</option>
		</select></td>


		<td><input type="text" size="10" id="c<%=x %>" name="c<%=x %>"
			maxlength="20" tabindex="2" /></td>
	</tr>
	<input type="hidden" value="<%=x %>" name="hiddenValueProcedure"
		id="hiddenValueProcedure" />

</table>


<div class="Clear"></div>



</div>
<div class="Clear"></div>
<div class="division"></div>
<label>ETT/ LMA</label> <select name="ett_lma" id="ett_lma" tabindex="2">
	<%

   if(otPostAnaesthesiaProcedure.getEttLma().equals("e")) {%>

	<option value="e" selected="selected">ETT Size</option>
	<option value="l">LMA Size</option>
	<%}else if(otPostAnaesthesiaProcedure.getEttLma().equals("l")){ %>
	<option value="e">ETT Size</option>
	<option value="l" selected="selected">LMA Size</option>


	<%}else{ %>

	<option value="">Select</option>
	<option value="e">ETT Size</option>
	<option value="l">LMA Size</option>



	<%}%>
</select> <%if(otPostAnaesthesiaProcedure.getEttLmaText() != 0 ){ %> <input
	name="ett_lma_text" type="text" maxlength="7"
	validate="ETT/ LMA Text,num,no" tabindex="2"
	value="<%=otPostAnaesthesiaProcedure.getEttLmaText() %>" /> <%}else{ %>
<input name="ett_lma_text" type="text" maxlength="7"
	validate="ETT/ LMA Text,num,no" tabindex="2" /> <%} %>


<div class="Clear"></div>
<div class="blockTitle">Monitoring</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="medium">ECG</label> <%if(otPostAnaesthesiaProcedure.getEcg() != "" && otPostAnaesthesiaProcedure.getEcg()!=null){ %>
<input name="ecg" type="text" tabindex="2" maxlength="15"
	value="<%=otPostAnaesthesiaProcedure.getEcg() %>" /> <%}else{ %> <input
	name="ecg" type="text" tabindex="2" maxlength="15" /> <%} %> <label
	class="medium">NIBP</label> <%if(otPostAnaesthesiaProcedure.getNibp() != "" && otPostAnaesthesiaProcedure.getNibp()!=null){ %>
<input name="nibp" type="text" class="calDate" tabindex="2"
	maxlength="7" value="<%=otPostAnaesthesiaProcedure.getNibp() %>" /> <%}else{ %>
<input name="nibp" type="text" class="calDate" tabindex="2"
	maxlength="7" /> <%} %> <label class="unit">mm Hg </label> <label
	class="medium">CVP</label> <%if(otPostAnaesthesiaProcedure.getCvp() != "" && otPostAnaesthesiaProcedure.getCvp()!=null){ %>
<input name="cvp" type="text" class="calDate" tabindex="2" maxlength="3"
	value="<%=otPostAnaesthesiaProcedure.getCvp() %>" /> <%}else{ %> <input
	name="cvp" type="text" class="calDate" tabindex="2" maxlength="3" /> <%} %>
<label class="unit">cm H<sub>2</sub>O </label> <label class="medium">Temp</label>


<%if(otPostAnaesthesiaProcedure.getTemp() != "" && otPostAnaesthesiaProcedure.getTemp()!=null){ %>
<input name="temp" type="text" style="width: 100px;" size="5"
	tabindex="2" maxlength="15"
	value="<%=otPostAnaesthesiaProcedure.getTemp() %>" /> <%}else{ %> <input
	name="temp" type="text" style="width: 100px;" size="5" tabindex="2"
	maxlength="15" /> <%} %>

<div class="Clear"></div>
<label class="medium">S<sub>p</sub>O<sub>2</sub></label> <%if(otPostAnaesthesiaProcedure.getSp02() != "" && otPostAnaesthesiaProcedure.getSp02()!=null){ %>
<input name="sp02" type="text" tabindex="2" maxlength="15"
	value="<%=otPostAnaesthesiaProcedure.getSp02() %>" /> <%}else{ %> <input
	name="sp02" type="text" tabindex="2" maxlength="15" /> <%} %> <label
	class="medium">LABP</label> <%if(otPostAnaesthesiaProcedure.getIabp() != "" && otPostAnaesthesiaProcedure.getIabp()!=null){ %>

<input name="labp" type="text" class="calDate" tabindex="2"
	maxlength="7" value="<%=otPostAnaesthesiaProcedure.getIabp() %>" /> <%}else{ %>
<input name="labp" type="text" class="calDate" tabindex="2"
	maxlength="7" /> <%} %> <label class="unit">mm Hg </label> <label
	class="medium">UO</label> <%if(otPostAnaesthesiaProcedure.getUo() != "" && otPostAnaesthesiaProcedure.getUo()!=null){ %>
<input name="uo" type="text" class="calDate" tabindex="2" maxlength="3"
	value="<%=otPostAnaesthesiaProcedure.getUo() %>" /> <%}else{ %> <input
	name="uo" type="text" class="calDate" tabindex="2" maxlength="3" /> <%} %>


<label class="unit">ml</label></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="tableHolderAuto"><label class="noWidth">IV
Fluids </label> <input name="Add4" type="button" class="cmnButton" value="Add"
	onclick="addRowForFluids();" tabindex="2" /> <input name="Delete4"
	type="button" class="cmnButton" value="Delete"
	onclick="removeRowForFluids();" tabindex="2" />
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="fluidsGrid">
	<tr>

		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS/ NIV No.</th>
		<th scope="col">Fluid Name</th>
		<th scope="col">Volume (ml)</th>
	</tr>



	<%
	    int y=1;
	    	Iterator surgeyPaIvFluidsDetailItr= surgeyPaIvFluidsDetailList.iterator();
	    	while(surgeyPaIvFluidsDetailItr.hasNext())
	    	{
	    		OtSurgeyPaIvFluidsDetail surgeyPaIvFluidsDetail=(OtSurgeyPaIvFluidsDetail)surgeyPaIvFluidsDetailItr.next();



	    %>
	<tr>


		<td><input type="text" name="nomenclature<%=y %>"
			id="nomenclature1<%=y %>"
			value="<%=surgeyPaIvFluidsDetail.getItem().getNomenclature()%>[<%=surgeyPaIvFluidsDetail.getItem().getPvmsNo()%>]"
			size="43" readonly="readonly" />
		<div id="ac2update1"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>

		</td>

		<td><input type="text" name="pvmsNo1<%=y %>" id="pvmsNo1<%=y %>"
			value="<%=surgeyPaIvFluidsDetail.getItem().getPvmsNo() %>" size="10" readonly="readonly" />
		</td>


		<td>
		<%if(surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailFluidsName() != "" && surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailFluidsName()!=null){ %>
		<input type="text" name="fluidName<%=y %>" id="fluidName<%=y %>"
			value="<%=surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailFluidsName() %>"
			size="10" readonly="readonly" /> <%}else{ %> <label class="value">-</label> <%} %>
		</td>


		<td><input type="text" name="v<%=y %>" id="v<%=y %>"
			value="<%=surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailVolume() %>"
			size="10" readonly="readonly" /></td>

	</tr>
	<%
	   y++;	}
	  %>



	<tr>


		<td><input type="text" value="" tabindex="2"
			id="nomenclature<%=y %>" size="43" name="nomenclature<%=y %>"
			onblur="populatePVMS(this.value,'<%=y%>')" />
		<div id="ac2update1"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=y %>','ac2update1','ot?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature<%=y %>'});
			</script></td>
		<td><input type="text" name="pvmsNo<%=y %>" id="pvmsNo<%=y %>"
			size="10" /></td>


		<td><input name="fluidName<%=y %>" id="fluidName<%=y %>"
			type="text" size="10" maxlength="30" tabindex="2" /></td>

		<td><input type="text" size="5" id="v<%=y %>" name="v<%=y %>"
			maxlength="4" validate="Volume,num,no" tabindex="2" /></td>
	</tr>
	<input type="hidden" value="<%=y %>" name="hiddenValueFluids"
		id="hiddenValueFluids" />




</table>
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<div class="blockTitle">Reversal</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label class="medium">Neostigmine</label>

<%if(otPostAnaesthesiaProcedure.getNeostigmine() != 0){ %> <input
	name="neostigmine" type="text" tabindex="2" maxlength="7"
	validate="Neostigmine,num,no"
	value="<%=otPostAnaesthesiaProcedure.getNeostigmine() %>" /> <%}else{ %>
<input name="neostigmine" type="text" tabindex="2" maxlength="7"
	validate="Neostigmine,num,no" /> <%} %> <label class="unit">mg</label> <label>Glycophyrrolate</label>

<%if(otPostAnaesthesiaProcedure.getGlycophyrrolate() != 0){ %> <input
	name="glycophyrrolate" type="text" tabindex="2" maxlength="7"
	validate="Glycophyrrolate,num,no"
	value="<%=otPostAnaesthesiaProcedure.getGlycophyrrolate() %>" /> <%}else{ %>
<input name="glycophyrrolate" type="text" tabindex="2" maxlength="7"
	validate="Glycophyrrolate,num,no" /> <%} %> <label class="unit">mm&nbsp;&nbsp;
&nbsp;&nbsp; </label> <label class="medium">Others</label> <%if(otPostAnaesthesiaProcedure.getOthers() != 0){ %>
<input name="others" type="text" tabindex="2" maxlength="7"
	validate="others,num,no"
	value="<%=otPostAnaesthesiaProcedure.getOthers() %>" /> <%}else{ %> <input
	name="others" type="text" tabindex="2" maxlength="7"
	validate="others,num,no" /> <%} %>

<div class="Clear"></div>
<label class="medium">Recovery</label>
<%if(otPostAnaesthesiaProcedure.getRecovery() != "" && otPostAnaesthesiaProcedure.getRecovery()!=null){ %>
<textarea onkeyup="chkLength(this,500);"
	name="recovery" cols="0" rows="0" tabindex="2"><%=otPostAnaesthesiaProcedure.getRecovery() %></textarea>
<%}else{ %> <textarea onkeyup="chkLength(this,500);" name="recovery" cols="0" rows="0" tabindex="2"></textarea>
<%} %>
</div>

<div class="Clear"></div>
<div class="blockFrame"><label class="medium">Risk Grade</label> <%if(otPostAnaesthesiaProcedure.getRiskGrade() != "" && otPostAnaesthesiaProcedure.getRiskGrade()!=null){ %>
<input type="text"
	value="<%=otPostAnaesthesiaProcedure.getRiskGrade() %>"
	name="risk_grade" id="risk1"> <%}else{ %> <select
	name="risk_grade" id="risk1" class="date" tabindex="2">
	<option value="">Select</option>
	<option value="I">I</option>
	<option value="II">II</option>
	<option value="3">III</option>
	<option value="IV">IV</option>
</select> <%} %> <label class="medium">E/ Others</label> <select name="e_others"
	id="eo1" class="date" tabindex="2">
	<%

   if(otPostAnaesthesiaProcedure.getEOthers().equals("e")) {%>

	<option value="e" selected="selected">E</option>
	<option value="o">Others</option>
	<%}else if(otPostAnaesthesiaProcedure.getEOthers().equals("o")){ %>
	<option value="e">E</option>
	<option value="o" selected="selected">Others</option>


	<%}else{ %>

	<option value="">Select</option>
	<option value="e">E</option>
	<option value="o">Others</option>



	<%}%>
</select>
<%if(otPostAnaesthesiaProcedure.getRemarks() != "" && otPostAnaesthesiaProcedure.getRemarks()!=null){ %>
<textarea onkeyup="chkLength(this,500);"
	name="remarks" cols="0" rows="0" tabindex="2"><%=otPostAnaesthesiaProcedure.getRemarks() %></textarea>
 <%}else{ %>
	 <textarea	onkeyup="chkLength(this,500);" name="remarks" cols="0" rows="0"	tabindex="2"></textarea> 
 <%} %>

	 <label class="medium">Pre-op Assessment</label>
	 <%if(otPostAnaesthesiaProcedure.getPreOpAssessment() != "" && otPostAnaesthesiaProcedure.getPreOpAssessment()!=null){ %>
<textarea onkeyup="chkLength(this,250);"
	name="pre_assessment" cols="0" rows="0" tabindex="2"><%=otPostAnaesthesiaProcedure.getPreOpAssessment() %></textarea>
 <%}else{ %>
<textarea onkeyup="chkLength(this,250);" name="pre_assessment" cols="0" rows="0" tabindex="2"></textarea>
<%} %>

</div>



<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="Clear"></div>
<div class="Height10"></div>

<input type="button" name="update" class="button" value="Update"
	onclick="submitForm ('postAnesthesiaProcedure','ot?method=updateOtPostAnesthesiaProcedure')" />

<input type="button" name="Back" class="button" value="Back"
	onclick="submitForm ('postAnesthesiaProcedure','ot?method=showOtPostAnaesthesiaPatientSearchJsp')" />

<input name="userName" id="userName" type="hidden"
	value="<%=userName %>" /> <input name="userName" id="userName"
	type="hidden" value="<%=userName %>" /> <input type="hidden"
	name="orderNo" value="<%=otbook.getOrderNo() %>" /> <input
	name="hinId" type="hidden" value="<%=otbook.getHin().getId()%>" /> <input
	name="departmentId" type="hidden"
	value="<%=otbook.getDepartment().getId()%>" /> <input name="hospitalId"
	type="hidden" value="<%=hospitalId%>" /> <input name="changedDate"
	type="hidden" value="<%=currentDate %>" /> <input name="changedTime"
	type="hidden" value="<%=currentTime %>" /> <input name="postId"
	type="hidden" value="<%=otPostAnaesthesiaProcedure.getId()%>" /></div>
<%}}else {%> <label>no Record found</label> <%} %>
</form>
</div>



<script type="text/javascript" language="javascript">

//----------------------------------------------  Premedication-------------------------
		function populatePVMSPr1(val,inc){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		   //  alert("pvms no--"+pvmsNo)



	  if(pvmsNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('nomenclaturePr'+inc).value="";
	    document.getElementById('pvmsNoPr'+inc).value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNoPr'+inc).value=pvmsNo;
	 }
	}
function addRowForPremedication(){

	  var tbl = document.getElementById('premedicationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValuePremedication');
	  hdb.value=iteration;
	//   alert("iteration row--"+iteration)


 	var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('Select');
	   e1.name='typePIM'+(iteration);
	  e1.id='typePIM'+(iteration);
	  e1.classname='smalllabel'
	   e1.options[0] = new Option('Select', '');
	   e1.options[1] = new Option('Premedication', 'p');
	   e1.options[2] = new Option('Induction', 'i');
	   //e1.options[3] = new Option('Maintenance', 'm');

	   cellRight1.appendChild(e1);


    var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	                       var val=e0.value
	                       if(val != "")
							{

						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						    	//alert("nomenclature---"+nomenclature)
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclaturePr'+(iteration)).value="";
	   								document.getElementById('pvmsNoPr'+(iteration)).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNoPr'+(iteration)).value=pvmsNo
						   }
	  					  };
	  e0.name = 'nomenclaturePr' + (iteration);
	  e0.id = 'nomenclaturePr' + (iteration);

	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclaturePr'+(iteration),'ac2update3','ot?method=getItemPrList',{parameters:'requiredField=nomenclaturePr'+(iteration)});


	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoPr'+(iteration);
	  sel.id='pvmsNoPr'+(iteration)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);




	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'dv' + (iteration);
	  e3.id = 'dv' + (iteration);
	  e3.size = '10'
	  cellRight3.appendChild(e3);




	 var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');

	  e4.name='route'+(iteration);
	  e4.id='route'+(iteration);
	  e4.classname='smalllabel'
	   e4.options[0] = new Option('Select', '');
	   e4.options[1] = new Option('1/V', '1/V');
	   e4.options[2] = new Option('1/M', '1/M');
	   e4.options[3] = new Option('Oral', 'Oral');
	    e4.options[4] = new Option('S.C.', 'S.C.');
	   cellRight4.appendChild(e4);



	}
	function removeRowForPremedication()
	{
	  var tbl = document.getElementById('premedicationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2)
	  {
		  tbl.deleteRow(lastRow - 1);
		  var hdb = document.getElementById('hiddenValuePremedication');
		  hdb.value=tbl.rows.length - 1;
	  }
	}

</script>
<script type="text/javascript" language="javascript"><!--

	//-------------------------------Procedure --------------------------------

		function populatePVMSP1(val,inc){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNoP = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		   //  alert("pvms no--"+pvmsNo)



	  if(pvmsNoP == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('nomenclatureP'+inc).value="";
	    document.getElementById('pvmsNoP'+inc).value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNoP'+inc).value=pvmsNoP
	 }
	}


function addRowForProcedure(){

	  var tbl = document.getElementById('procedureGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValueProcedure');
	  hdb.value=iteration;
	//   alert("iteration row--"+iteration)

 	var val = document.getElementById('anesthesia_id').value;

	if(val != 0){
 	var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('Select');

	  e1.name='anesthesia'+(iteration);
	  e1.id='anesthesia'+(iteration);
	  e1.classname='smalllabel';
	   e1.options[0] = new Option('Select', '');
	   e1.options[1] = new Option('SA', 'SA');
	   e1.options[2] = new Option('EA + Cath', 'EA + Cath');
	   e1.options[3] = new Option('EA', 'EA');
	   e1.options[4] = new Option('RA', 'RA');
	   e1.options[5] = new Option('Caudal', 'Caudal');

	           cellRight1.appendChild(e1);

	        	 //  e1.onblur=function(){

	           //            var val=e1.value
	            //           if(val == "SA")
				//			{
				//	    		var cellRight0 = row.insertCell(1);
	 			////				var e0 = document.createElement('input');
	  			//				e0.type = 'text';
	  			//				e0.name = 'nomenclatureP' + (iteration);
	  			//				e0.id = 'nomenclatureP' + (iteration);
	  			//				e0.value='Bupivacaie HCL Inj 0.5% heavy amp of 4ml [010116]'
	  			//				e0.size = '43'
	 			//				cellRight0.appendChild(e0);

		  		//				var cellRightSel = row.insertCell(2);
	  			//				var sel = document.createElement('input');
	  			///				sel.type = 'text';
	  			//				sel.name='pvmsNoP'+(iteration);
				//				  sel.id='pvmsNoP'+(iteration)
				//				  sel.value='010116'
				//				  sel.size = '10'
				//				  cellRightSel.appendChild(sel);



			//	  var cellRight3 = row.insertCell(3);
	 // var e3 = document.createElement('input');
	  //e3.type = 'text';
	 // e3.name = 'd' + (iteration);
	  //e3.id = 'd' + (iteration);
	  //e3.size = '10'
	 // cellRight3.appendChild(e3);


								//	 var cellRight4 = row.insertCell(4);
	  //var e4 = document.createElement('Select');

	  //e4.name='level'+(iteration);
	  //e4.id='level'+(iteration);
	  //e4.classname='smalllabel'
	  // e4.options[0] = new Option('Select', '');
	  // e4.options[1] = new Option('L1-2', 'L1-2');
	  // e4.options[2] = new Option('L2-3', 'L2-3');
	  // e4.options[3] = new Option('L3-4', 'L3-4');
	  // cellRight4.appendChild(e4);


	  //var cellRight5 = row.insertCell(5);
	 // var e5 = document.createElement('input');
	 // e5.type = 'text';
	 // e5.name = 'c' + (iteration);
	 // e5.id = 'c' + (iteration);

	 // e5.size = '10'
	 // cellRight5.appendChild(e5);



  //}
					//	   else if(val == "EA")
				//		   {
				//		   var cellRight0 = row.insertCell(1);
	  //var e0 = document.createElement('input');
	 // e0.type = 'text';
	 // e0.name = 'nomenclatureP' + (iteration);
	 // e0.id = 'nomenclatureP' + (iteration);
	 // e0.value='Bupivacaine HCL 0.5% vial of 20 ml[010115]'
	 // e0.size = '43'
	 // cellRight0.appendChild(e0);


	 // var cellRightSel = row.insertCell(2);
	 // var sel = document.createElement('input');
	 // sel.type = 'text';
	 // sel.name='pvmsNoP'+(iteration);
	 // sel.id='pvmsNoP'+(iteration)
	 //   sel.value='010115'
	 // sel.size = '10'
	 // cellRightSel.appendChild(sel);


		//		  var cellRight3 = row.insertCell(3);
	  //var e3 = document.createElement('input');
	 // e3.type = 'text';
	 /// e3.name = 'd' + (iteration);
	 // e3.id = 'd' + (iteration);
	//  e3.size = '10'
	 // cellRight3.appendChild(e3);



	  	// var cellRight4 = row.insertCell(4);
	 // var e4 = document.createElement('Select');

	 // e4.name='level'+(iteration);
	 // e4.id='level'+(iteration);
	 /// e4.classname='smalllabel'
	 ///  e4.options[0] = new Option('Select', '');

	 //   e4.options[1] = new Option('T1-2', 'T1-2');
	 //  e4.options[2] = new Option('T2-3', 'T2-3');
	 //    e4.options[3] = new Option('T3-4', 'T3-4');
	 //  e4.options[4] = new Option('T4-5', 'T4-5');
	 //  e4.options[5] = new Option('T6-7', 'T6-7');
	 //    e4.options[6] = new Option('T8-L1', 'T8-L1');
	 //  e4.options[7] = new Option('L1-2', 'L1-2');
	 //  e4.options[8] = new Option('L2-3', 'L2-3');
	 //  e4.options[9] = new Option('L3-4', 'L3-4');
	 //  cellRight4.appendChild(e4);



	 // var cellRight5 = row.insertCell(5);
	 // var e5 = document.createElement('input');
	//  e5.type = 'text';
	 // e5.name = 'c' + (iteration);
	//  e5.id = 'c' + (iteration);

	 // e5.size = '10'
	//  cellRight5.appendChild(e5);


	//					   }
	//					   else if(val=="Caudal")
	//					   {
	//	var cellRight0 = row.insertCell(1);
	//  var e0 = document.createElement('input');
	//  e0.type = 'text';
	//  e0.name = 'nomenclatureP' + (iteration);
	//  e0.id = 'nomenclatureP' + (iteration);
//	  e0.value='Bupivacaine HCL 0.5% vial of 20 ml[010115]'
	//  e0.size = '43'
	//  cellRight0.appendChild(e0);
	//

	//  var cellRightSel = row.insertCell(2);
	//  var sel = document.createElement('input');
	//  sel.type = 'text';
	//  sel.name='pvmsNoP'+(iteration);
	//  sel.id='pvmsNoP'+(iteration)
	//  sel.value='010115'
	//  sel.size = '10'
	//  cellRightSel.appendChild(sel);


	 // 				  var cellRight3 = row.insertCell(3);
	 // var e3 = document.createElement('input');
	//  e3.type = 'text';
	  //e3.name = 'd' + (iteration);
	//  e3.id = 'd' + (iteration);
	//  e3.size = '10'
	//  cellRight3.appendChild(e3);



	  //	var cellRight4 = row.insertCell(4);
	//  var e4 = document.createElement('input');
	 //
	//  e4.name='level'+(iteration);
	//  e4.id='level'+(iteration);
	//   e4.value='-';
	//e4.size = '2'
 	//cellRight4.appendChild(e4);

  //var cellRight5 = row.insertCell(5);
	//  var e5 = document.createElement('input');
	//  e5.type = 'text';
	//  e5.name = 'c' + (iteration);
	//  e5.id = 'c' + (iteration);

	//  e5.size = '10'
	//  cellRight5.appendChild(e5);




	//					   }
		//				   else
	//					   {


	//  var cellRight0 = row.insertCell(1);
	//  var e0 = document.createElement('input');
	//  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	//  e0.onblur=function(){

	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	        //               var val=e0.value
	         //              if(val != "")
			//				{

			//			    var index1 = val.lastIndexOf("[");
			///			    var indexForPvms=index1;
			////			    var index2 = val.lastIndexOf("]");
			//			    index1++;
			//			    var pvmsNo = val.substring(index1,index2);
			//			    var indexForPvms=indexForPvms--;
			////			    var nomenclature=val.substring(0,indexForPvms);
			//			    	//alert("nomenclature---"+nomenclature)
		///				   	 if(pvmsNo =="")
		//				    {
		//				    		document.getElementById('nomenclatureP'+(iteration)).value="";
	   	//							document.getElementById('pvmsNoP'+(iteration)).value="";
		//				     return;
		//				    }
			//			    else
	  //    						document.getElementById('pvmsNoP'+(iteration)).value=pvmsNo
		//				   }
	  //					  };
	//  e0.name = 'nomenclatureP' + (iteration);
	//  e0.id = 'nomenclatureP' + (iteration);

	//  e0.size = '43';
	  //cellRight0.appendChild(e0);
	 // new Ajax.Autocompleter('nomenclatureP'+(iteration),'ac2update2','ot?method=getItemPList',{parameters:'requiredField=nomenclatureP'+(iteration)});
	   //alert("name--"+e0.name)

	 // var cellRightSel = row.insertCell(2);
	  //var sel = document.createElement('input');
	 // sel.type = 'text';
	 // sel.name='pvmsNoP'+(iteration);
	 // sel.id='pvmsNoP'+(iteration)
	  //sel.size = '10'
	  //cellRightSel.appendChild(sel);



		//		  var cellRight3 = row.insertCell(3);
	//  var e3 = document.createElement('input');
	 // e3.type = 'text';
	 // e3.name = 'd' + (iteration);
	 // e3.id = 'd' + (iteration);
	 // e3.size = '10'
	 // cellRight3.appendChild(e3);



	  //	var cellRight4 = row.insertCell(4);
	  //var e4 = document.createElement('input');

	 // e4.name='level'+(iteration);
	 /// e4.id='level'+(iteration);
	  // e4.value='-';
	//e4.size = '2'

	// cellRight4.appendChild(e4);

	 // var cellRight5 = row.insertCell(5);
	 // var e5 = document.createElement('input');
	 // e5.type = 'text';
	 // e5.name = 'c' + (iteration);
	 // e5.id = 'c' + (iteration);

	 // e5.size = '10'
	 // cellRight5.appendChild(e5);



	//}





 //};


	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	                       var val=e0.value
	                       if(val != "")
							{

						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						    	//alert("nomenclature---"+nomenclature)
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclatureP'+(iteration)).value="";
	   								document.getElementById('pvmsNoP'+(iteration)).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNoP'+(iteration)).value=pvmsNo
						   }
	  					  };
	  e0.name = 'nomenclatureP' + (iteration);
	  e0.id = 'nomenclatureP' + (iteration);

	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclatureP'+(iteration),'ac2update2','ot?method=getItemPList',{parameters:'requiredField=nomenclatureP'+(iteration)});
	   //alert("name--"+e0.name)



	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration);
	  sel.id='pvmsNoP'+(iteration)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);




	     var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration);
	  e3.id = 'd' + (iteration);
	  e3.size = '10'
	  cellRight3.appendChild(e3);

	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	  e4.name='level'+(iteration);
	  e4.id='level'+(iteration);
	  e4.options[0]=new Option('Select','');
	  e4.options[1]=new Option('L1-2','L1-2');
	  e4.options[2]=new Option('L2-3','L2-3');
	  e4.options[3]=new Option('L3-L4','L3-L4');
      cellRight4.appendChild(e4);


	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration);
	  e5.id = 'c' + (iteration);

	  e5.size = '10'
	  cellRight5.appendChild(e5);




	}
	else
	{
	var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');

	  e1.name='anesthesia'+(iteration);
	  e1.id='anesthesia'+(iteration);
	   e1.value='-';
	e1.size = '2'

	   cellRight1.appendChild(e1);




	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	                       var val=e0.value
	                       if(val != "")
							{

						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						    	//alert("nomenclature---"+nomenclature)
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclatureP'+(iteration)).value="";
	   								document.getElementById('pvmsNoP'+(iteration)).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNoP'+(iteration)).value=pvmsNo
						   }
	  					  };
	  e0.name = 'nomenclatureP' + (iteration);
	  e0.id = 'nomenclatureP' + (iteration);

	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclatureP'+(iteration),'ac2update2','ot?method=getItemPList',{parameters:'requiredField=nomenclatureP'+(iteration)});
	   //alert("name--"+e0.name)

	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration);
	  sel.id='pvmsNoP'+(iteration)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);




	     var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration);
	  e3.id = 'd' + (iteration);
	  e3.size = '10'
	  cellRight3.appendChild(e3);


	  var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	  e4.name='level'+(iteration);
	  e4.id='level'+(iteration);
	  e4.options[0]=new Option('Select','');
	  e4.options[1]=new Option('L1-2','L1-2');
	  e4.options[2]=new Option('L2-3','L2-3');
	  e4.options[3]=new Option('L3-L4','L3-L4');
      cellRight4.appendChild(e4);

	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration);
	  e5.id = 'c' + (iteration);

	  e5.size = '10'
	  cellRight5.appendChild(e5);


	}





	}
	function removeRowForProcedure()
	{
	  var tbl = document.getElementById('procedureGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2)
	  {
		  tbl.deleteRow(lastRow - 1);
		  var hdb = document.getElementById('hiddenValueProcedure');
		  hdb.value=tbl.rows.length - 1;
	  }


	}


//-------------------------------IV  Fluids --------------------------------
		function populatePVMS(val,inc){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		   //  alert("pvms no--"+pvmsNo)



	  if(pvmsNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)
	   	document.getElementById('nomenclature'+inc).value="";
	    document.getElementById('pvmsNo'+inc).value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNo'+inc).value=pvmsNo
	 }
	}

function addRowForFluids(){

	  var tbl = document.getElementById('fluidsGrid');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValueFluids');
	  hdb.value=iteration;	//   alert("iteration row--"+iteration)




	 var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	                       var val=e0.value
	                       if(val != "")
							{

						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						    	//alert("nomenclature---"+nomenclature)
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+(iteration)).value="";
	   								document.getElementById('pvmsNo'+iteration).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+(iteration)).value=pvmsNo
						   }
	  					  };

	  e0.name = 'nomenclature' +(iteration);
	  e0.id = 'nomenclature' +(iteration);

	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclature'+(iteration),'ac2update1','ot?method=getItemList',{parameters:'requiredField=nomenclature'+(iteration)});
	   //alert("name--"+e0.name)

	  var cellRightSel = row.insertCell(1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNo'+(iteration);
	  sel.id='pvmsNo'+(iteration);
	  sel.size = '10'
	  cellRightSel.appendChild(sel);




	   var cellRight3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'fluidName' + (iteration);
	  e3.id = 'fluidName' + (iteration);

	  e3.size = '10'
	  cellRight3.appendChild(e3);


	  var cellRight4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'v' + (iteration);
	  e4.id = 'v' + (iteration);

	  e4.size = '2'
	  cellRight4.appendChild(e4);


	}
	function removeRowForFluids()
	{
	  var tbl = document.getElementById('fluidsGrid');
	  var lastRow = tbl.rows.length;

	  if (lastRow > 2)
	  {
		  tbl.deleteRow(lastRow - 1);
		  var hdb = document.getElementById('hiddenValueFluids');
		  hdb.value=tbl.rows.length- 1;
	  }
	}



		--></script>
<script type="text/javascript" language="javascript">

function validateSurgeryAutoComplete( strValue,inc ) {

 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    //alert("id----"+id)

		    if(id =="")
		    {
		    		document.getElementById('chargeCodeName'+inc).value="";
	   				document.getElementById('chargeCode'+inc).value="";
 					return ;
 			}


 			return true;
		}


function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration;
	  // alert("iteration row--"+iteration)




	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e0.innerHTML = iteration+':'
	 // e1.onblur=function(){
	  //
	 // 						if(validateSurgeryAutoComplete(this.value,(iteration))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillChargeCode&rowVal='+(iteration),'chargeCodeVal'+(iteration));}

	  //					  };
	  e1.name = 'chargeCodeName' + (iteration);
	  e1.id = 'chargeCodeName' + (iteration);
	  //alert("name--"+e0.name)
	  e1.size = '43'
	  cellRight1.appendChild(e1);
	new Ajax.Autocompleter('chargeCodeName'+(iteration),'ac2update6','ot?method=getSurgeyForAutoComplete',{parameters:'requiredField=chargeCodeName'+(iteration)});


	  //var cellRightSel = row.insertCell(1);
	  cellRightSel.id='chargeCodeVal'+(iteration);
	  var sel = document.createElement('input');
	  sel.type = 'hidden';
	  sel.name='chargeCode'+(iteration);
	  sel.id='chargeCode'+(iteration)
	  sel.size = '10'
	  cellRight1.appendChild(sel);





	}
	function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2)
	  {
		  tbl.deleteRow(lastRow - 1);
		  var hdb = document.getElementById('hiddenValue');
		  hdb.value=tbl.rows.length- 1;
	  }
	}
	</script>
<script type="text/javascript" language="javascript">
//----------------------------- Surgeon -----------------------------

	function validateSergonAutoComplete( strValue1,inc1 ) {

 			var index1 = strValue1.lastIndexOf("[");
		    var index2 = strValue1.lastIndexOf("]");
		    index1++;
		    var id = strValue1.substring(index1,index2);
		    //alert("id----"+id)

		    if(id =="")
		    {
		    		document.getElementById('empNameS'+inc1).value="";

	   				return ;
 			}


 			return true;
		}


function addRowForSurgeon(){

	  var tbl = document.getElementById('sergonGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdbS = document.getElementById('hiddenValueSergon');
	  hdbS.value=iteration;
	  // alert("iteration row--"+iteration)




	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e0.innerHTML = iteration+':'
	  //e1.onblur=function(){

	  //						if(validateSergonAutoComplete(this.value,(iteration))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameSergonForPostAnesthesia&rowVal='+(iteration),''+(iteration));}
	 //
	  //					  };
	 // e1.onblur=function(){

	  	//					if(validateSergonAutoComplete(this.value,(iteration))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameSergonForPostAnesthesia&rowVal='+(iteration),''+(iteration));}

	  	//				  };

	  e1.name = 'empNameS' + (iteration);
	  e1.id = 'empNameS' + (iteration);
	  //alert("name--"+e0.name)
	  e1.size = '43'
	  cellRight1.appendChild(e1);
	new Ajax.Autocompleter('empNameS'+(iteration),'ac2update5','ot?method=getSergonForAutoComplete',{parameters:'requiredField=empNameS'+(iteration)});






	}
	function removeRowForSurgeon()
	{
	  var tbl = document.getElementById('sergonGrid');
	  var lastRow = tbl.rows.length;
		  if (lastRow > 2)
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueSergon');
	  hdb.value=tbl.rows.length- 1;
	  }
	}
	</script>
<script type="text/javascript" language="javascript">
//-------------------- 		Anesthesiologist----------------------


	function validateAnesthesiologistAutoComplete( strValue2,inc2 ) {

 			var index1 = strValue2.lastIndexOf("[");
		    var index2 = strValue2.lastIndexOf("]");
		    index1++;
		    var id = strValue2.substring(index1,index2);
		    //alert("id----"+id)

		    if(id =="")
		    {
		    		document.getElementById('empName'+inc2).value="";

	   				return ;
 			}


 			return true;
		}


function addRowForAnesthesiologist(){

	  var tbl = document.getElementById('anesthesiologistGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdbS = document.getElementById('hiddenValueAnesthesiologist');
	  hdbS.value=iteration
	  // alert("iteration row--"+iteration)




	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e0.innerHTML = iteration+':'
	  //e1.onblur=function(){

	  	//					if(validateAnesthesiologistAutoComplete(this.value,(iteration))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameAnesthesiologist&rowVal='+(iteration),''+(iteration));}

	  //					  };
	  e1.name = 'empName' + (iteration);
	  e1.id = 'empName' + (iteration);
	  //alert("name--"+e0.name)
	  e1.size = '43'
	  cellRight1.appendChild(e1);
	new Ajax.Autocompleter('empName'+(iteration),'ac2update4','ot?method=getAnesthesiologistForAutoComplete',{parameters:'requiredField=empName'+(iteration)});






	}
	function removeRowForAnesthesiologist()
	{
	  var tbl = document.getElementById('anesthesiologistGrid');
	  var lastRow = tbl.rows.length;
		  if (lastRow > 2)
	  {
		  tbl.deleteRow(lastRow - 1);
		  var hdb = document.getElementById('hiddenValueAnesthesiologist');
		  hdb.value=tbl.rows.length- 1;
	  }
	}

	function anesthesiaCheck()
	{
		var val = document.getElementById('anesthesia_id').value;

			if(val != 0){

				document.getElementById('s1').style.display = 'none';
				document.getElementById('s2').style.display = 'block';
			}else{
				document.getElementById('s1').style.display = 'block';
				document.getElementById('s2').style.display = 'none';
			}
	}
		function anesthesiaCobom()
	{
	var val = document.getElementById('anesthesia1').value;
	if(val == "SA"){
			document.getElementById('s3').style.display = 'none';
			document.getElementById('s4').style.display = 'block';
			document.getElementById('s5').style.display = 'none';

			}
	else if(val == "EA"){
			document.getElementById('s3').
			style.display = 'none';
			document.getElementById('s4').style.display = 'none';
			document.getElementById('s5').style.display = 'block';

			}

			else {
			document.getElementById('s3').style.display = 'block';
			document.getElementById('s4').style.display = 'none';
			document.getElementById('s5').style.display = 'none';

			}
	}

		function chkLength(field,maxLimit)
		{
		if(field.value.length > maxLimit)
		{
		 alert('Maximum Limit is '+maxLimit+' characters.');
		 var val=field.value.substring(0,maxLimit);
		 field.value='';
		}
		}

</script>