<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.PatientAllergicDrugsHd"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.PatientAllergicDrugsDt"%>
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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}


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

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="ent" action="" method="post">
<h6>OPD Patient Allergic Drugs</h6>
<div class="Clear"></div>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	int pageNo=1;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<Visit> patientDataList = new ArrayList<Visit>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	

	 List searchPatientAllergicDrugsDtList = new ArrayList();
		
		if(map.get("searchPatientAllergicDrugsDtList") != null){
			searchPatientAllergicDrugsDtList=(List)map.get("searchPatientAllergicDrugsDtList");
		}
	
	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}

	String userName = "";
	Integer deptId = 0;
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}

	if(map.get("pageNo") != null) {
		pageNo=(Integer)map.get("pageNo");
	}
	List itemList = new ArrayList();
	List<PatientAllergicDrugsHd> searchPatientAllergicDrugsHdList = new ArrayList<PatientAllergicDrugsHd>();
	if(map.get("searchPatientAllergicDrugsHdList") != null){
		searchPatientAllergicDrugsHdList=(List<PatientAllergicDrugsHd>)map.get("searchPatientAllergicDrugsHdList");
	}	

		
			
		if(detailsMap.get("itemList") != null){
			 itemList = (List)detailsMap.get("itemList");
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
<label>Service No. </label> <%if(visit.getHin().getServiceNo()!= null){ %>
<label class="value"><%=visit.getHin().getServiceNo() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Service Type</label> <%if(visit.getHin().getServiceType()!= null){ %>
<label class="value"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>HIN No. </label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Rank</label> <%if(visit.getHin().getRank()!= null){ %> <label
	class="value"><%=visit.getHin().getRank().getRankName() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Trade </label> <%if(visit.getHin().getTrade() != null){ %>
<label class="value"><%=visit.getHin().getTrade().getTradeName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Visit Time</label>
<%if(visit.getVisitTime() != null){ %> <label class="value"><%=visit.getVisitTime() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Patient Name. </label> <%if(patientName!= null){ %> <label
	class="value"><%=patientName %> </label> <%}else{ %> <label class="value">-
</label> <%} %> <label>Age</label> <%if(visit.getHin().getAge()!= null){ %> <label
	class="value"><%=visit.getHin().getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit no. </label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="Clear"></div>

<label>Visit Date </label> <%if(visitDateInString != null){ %> <label
	class="value"><%=visitDateInString %></label> <%}else{ %> <label
	class="value">-</label> <%} %>

<div class="division"></div>
<div class="Clear"></div>

<label class="medium">Phone Number</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %> <label
	class="medium">Mobile Number</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %>
</div>

<!--Block one Ends--> <%	if(searchPatientAllergicDrugsHdList.size() > 0){
	
	PatientAllergicDrugsHd patientAllergicDrugsHd = new PatientAllergicDrugsHd();
	patientAllergicDrugsHd = searchPatientAllergicDrugsHdList.get(0); %>
<div class="Clear"></div>

<!--Block two Start-->

<div class="Clear"></div>


<script type="text/javascript">
var amtArray = new Array();
<%
if(itemList!=null){
int counter=0;
Iterator ite = itemList.iterator();
while ( ite.hasNext() ) {
Object[] pair = (Object[]) ite.next();
MasStoreItem MasStoreItem = (MasStoreItem) pair[0];

%>
amtArray[<%=counter%>] = new Array();
amtArray[<%=counter%>][0]=<%=MasStoreItem.getId()%>;
amtArray[<%=counter%>][1] = <%=MasStoreItem.getNomenclature()%>;									

<%
counter++;
}
}
%>
</script> <input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <input type="hidden"
	size="2" value="" name="noOfRecords" id="noOfRecords" /> <input
	type="hidden" id="patientAllergicDrugshdId"
	value="<%= patientAllergicDrugsHd.getId()%>" /> <input type="hidden"
	name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>" /> <input type="hidden"
	id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="max" name="currentVisitId"
	value="<%=currentVisitId %>"> <input type="hidden" id="visitId"
	value="<%=visit.getId() %>">
<div class="Clear"></div>




<div class="division"></div>
<div class="tableHholderCmnLarge">
<% if(searchPatientAllergicDrugsDtList.size() > 0) { 
          Iterator itr=searchPatientAllergicDrugsDtList.iterator();%>
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>

			<th width="7%">PVMS No</th>
			<th width="10%">Nomenclature</th>
			<th width="7%">Special Instruction</th>
		</tr>
	</thead>
	<%
          while(itr.hasNext())
          			{
          				PatientAllergicDrugsDt patientAllergicDrugsDt=(PatientAllergicDrugsDt)itr.next();
          				
          			
      %>
	<tbody>

		<tr>


			<td><input type="text" name="<%=PVMS_NO %>"
				value="<%=patientAllergicDrugsDt.getItem().getPvmsNo() %>"
				id="pvmsNo" validate="PVMS No.,string,no" readonly /></td>

			<td width="10%"><input type="text"
				value="<%=patientAllergicDrugsDt.getItem().getNomenclature() %>"
				size="30" readonly tabindex="1" id="nomenclature"
				name="<%=NOMENCLATURE_OPD %>" /></td>
			<input type="hidden" value="" name="<%=ITEM_ID%>" id="itemId" />
			<td width="7%"><input type="text" id="instructions" tabindex="1"
				name="<%=INSTRUCTIONS %>"
				value="<%=patientAllergicDrugsDt.getSpecialInstruction() %>"
				readonly /></td>
		</tr>

		<%}%>
	</tbody>
</table>


</div>

<!--Block two Ends-->

<div class="division"></div>

<!--Bottom labels starts-->
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>

<div class="Clear"></div>
<input name="prev" type="button" class="button" value="Prev"
	onclick="submitForm('ent','opd?method=viewPatientAllergicDrug&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('ent','opd?method=viewPatientAllergicDrug&flag=next','patientVisitNext');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('ent','opd?method=showPatientAllergicDrugsJsp&visitId=<%=currentVisitId%>&deptId=<%=deptId%>');"
	align="right" /> <!-- <input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="submitForm('ent','opd?method=showOPDMainJsp&visitId=<%=visit.getId()%>&deptId=<%=visit.getDepartment().getId()%>');"  align="right"/> -->
<%}%>
</div>
<%}}else{%> <label style="width: auto;"><span>No Record
Found!!</span></label>
<div class="Clear"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="max" name="currentVisitId"
	value="<%=currentVisitId %>"> <input type="hidden" id="visitId"
	value="<%=visit.getId() %>"> <input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('ent','opd?method=viewPatientAllergicDrug&flag=prev','patientVisitPrev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('ent','opd?method=viewPatientAllergicDrug&flag=next','patientVisitNext');">
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('ent','opd?method=showPatientAllergicDrugsJsp&visitId=<%=currentVisitId%>&deptId=<%=deptId%>');"
	align="right" /> <!--  <input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="submitForm('ent','opd?method=showOPDMainJsp&visitId=<%=visit.getId()%>&deptId=<%=visit.getDepartment().getId()%>');"  align="right"/> -->
<!--Bottom labels ends--></div>
<%} %>
</form>
</div>

