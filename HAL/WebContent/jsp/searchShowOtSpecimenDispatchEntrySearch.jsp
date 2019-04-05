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
	

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String currentTime = (String)utilMap.get("currentTime");
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();
	 
			
	if(map.get("patientDetailList") != null){
		
		patientDetailList=(List)map.get("patientDetailList");
		
	}
	if(map.get("departmentList") != null){
			
		departmentList=(List)map.get("departmentList");
			
		}
	OtBooking patient=(OtBooking)patientDetailList.get(0);
	List<OtSpecimenDispatchEntry> otSpecimenDispatchEntryList = new ArrayList<OtSpecimenDispatchEntry>();
	if(map.get("otSpecimenDispatchEntryList") != null){
		otSpecimenDispatchEntryList=(List<OtSpecimenDispatchEntry>)map.get("otSpecimenDispatchEntryList");
	}	
	List<MasEmployee> empByList = new ArrayList<MasEmployee>();
	if(map.get("empByList") != null){
		empByList=(List<MasEmployee>)map.get("empByList");
	}	
	List<MasEmployee> empRevList = new ArrayList<MasEmployee>();
	if(map.get("empRevList") != null){
		empRevList=(List<MasEmployee>)map.get("empRevList");
	}	
	if(otSpecimenDispatchEntryList.size() > 0 && otSpecimenDispatchEntryList!= null){
		

			for (Iterator iter = otSpecimenDispatchEntryList.iterator(); iter.hasNext();) {
				OtSpecimenDispatchEntry otSpecimenDispatchEntry = (OtSpecimenDispatchEntry) iter.next();
	
		

		
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String patientName="";
	if(otSpecimenDispatchEntry.getHin().getPFirstName()!= null){
		patientName=otSpecimenDispatchEntry.getHin().getPFirstName();
	}
	if(otSpecimenDispatchEntry.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+otSpecimenDispatchEntry.getHin().getPMiddleName();
	}
	if(otSpecimenDispatchEntry.getHin().getPLastName()!= null){
		patientName=patientName+" "+otSpecimenDispatchEntry.getHin().getPLastName();
	}
	String servicePersonName="";
	if(otSpecimenDispatchEntry.getHin().getSFirstName()!= null){
		servicePersonName=otSpecimenDispatchEntry.getHin().getSFirstName();
	}
	if(otSpecimenDispatchEntry.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+otSpecimenDispatchEntry.getHin().getSMiddleName();
	}
	if(otSpecimenDispatchEntry.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+otSpecimenDispatchEntry.getHin().getSLastName();
	}
	
%>




<div id="contentHolder">
<form name="specimenDispatchEntry" action="" method="post">

<h6>Specimen Dispatch Entry</h6>
<div class="Clear"></div>
<div class="header"><label>Entry No</label> <label class="value"><input
	type="text" value="<%=otSpecimenDispatchEntry.getEntryNo() %>"
	name="entryNo" /></label> <label class="valuemedium">Date</label> <label
	class="value"><input type="text"
	value="<%=HMSUtil.changeDateToddMMyyyy(otSpecimenDispatchEntry.getOtSpecimenDispatchEntryDate()) %>"
	name="dateOfDispatch" /> </label></div>
<div class="Clear"></div>
<!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service Type</label> <%if(otSpecimenDispatchEntry.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Service No.</label> <%if(otSpecimenDispatchEntry.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getServiceNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium"> Serv. Status </label> <%if(otSpecimenDispatchEntry.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Name</label> <%if(servicePersonName != null){ %> <label
	class="valuemedium" style="width: auto;"><%=servicePersonName %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Relation</label> <%if(otSpecimenDispatchEntry.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getRelation().getRelationName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Rank</label> <%if(otSpecimenDispatchEntry.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getRank().getRankName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit</label> <%if(otSpecimenDispatchEntry.getHin().getUnit()!= null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">--</label> <%} %> <label
	class="medium">Unit Address</label> <% if(otSpecimenDispatchEntry.getHin().getUnit()!= null){%>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">--</label> <%} %>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(otSpecimenDispatchEntry.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getHinNo() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Patient Name. </label> <%if(patientName!= null){ %> <label
	class="valuemedium"><%=patientName %> </label> <%}else{ %> <label
	class="valuemedium">- </label> <%} %> <label class="medium">Age</label> <%if(otSpecimenDispatchEntry.getHin().getAge()!= null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getAge() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Patient Status </label> <%if(otSpecimenDispatchEntry.getHin().getPatientStatus() != null){ %>
<label class="valuemedium"><%=otSpecimenDispatchEntry.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>

<label class="medium">Reg.Date </label> <%if(otSpecimenDispatchEntry.getHin().getRegDate()!= null){ %>
<label class="valuemedium"><%=HMSUtil.changeDateToddMMyyyy(otSpecimenDispatchEntry.getHin().getRegDate()) %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>

<div class="Clear"></div>


</div>
<div class="division"></div>
<div class="Clear"></div>




<label class="noWidth" style="width: 106px;"><span>*</span>
Tissue/Organ</label> <input name="tissueOrgan" type="text" tabindex="1"
	size="43" maxlength="50" validate="Tissue,string,yes"
	value="<%=otSpecimenDispatchEntry.getTissueOrgan() %>" /> <label
	class="noWidth"><span>*</span> Specimen dispatched by</label> <select
	name="empBy" validate="Specimen dispatched by,string,yes"
	class="select_adt" id="empBy">
	<option value="0">Select</option>
	<%
	 		for(MasEmployee obj : empByList){
	 		%>
	<option value="<%=obj.getId() %>"><%=obj.getFirstName()+" "%><%=obj.getLastName()+" "%><%=obj.getMiddleName()%></option>
	<%
	 			}%>
</select> <script type="text/javascript">
          	<%  if(otSpecimenDispatchEntry.getSpecimenDispatchedBy()  != null){
			 			int disposalId = otSpecimenDispatchEntry.getSpecimenDispatchedBy().getId() ;
					%>
					document.specimenDispatchEntry.empBy.value = '<%=disposalId %>';
               <%		
			 		}%>
           </script> <label class="noWidth"><span>*</span> Specimen
received by</label> <select id="empRev" name="empRev"
	validate="Specimen Dispatch Received,string,yes" tabindex="2">
	<option value="0">Select</option>
	<%
	 		for(MasEmployee obj1 : empRevList){
	 		%>
	<option value="<%=obj1.getId() %>"><%=obj1.getFirstName()+" "%><%=obj1.getLastName()+" "%><%=obj1.getMiddleName()%></option>
	<%
	 			}%>
</select> <script type="text/javascript">
          	<%  if(otSpecimenDispatchEntry.getSpecimenReceivedBy()  != null){
			 			int ob = otSpecimenDispatchEntry.getSpecimenReceivedBy().getId() ;
					%>
					document.specimenDispatchEntry.empRev.value = '<%=ob %>';
               <%		
			 		}%>
           </script>


<div class="Clear"></div>

<label class="noWidth"><span>*</span> Time of dispatch</label> <input
	name="timeOfDispatch" id="timeOfDispatch" type="text" tabindex="10"
	maxlength="5"
	onKeyUp="maskWithBackspaceCheck(this.value,this,'2',':',event);"
	onblur="IsValidTimeWithBlankCheck(this.value,this.id)"
	validate="Time,string,yes"
	value="<%=otSpecimenDispatchEntry.getTimeOfDispatch() %>" /> <label
	class="noWidth" style="width: 151px;"><span>*</span>
Examination required</label> <input name="examinationRequired" type="text"
	tabindex="10" maxlength="50" validate="Examination Required,string,yes"
	value="<%=otSpecimenDispatchEntry.getExaminationRequired() %>" />


<div class="Clear"></div>
<label class="noWidth" style="width: 106px;"><span>*</span>
Clinical Notes</label> <input name="clinicalNotes" type="text" tabindex="2"
	class="large2" style="width: 290px;" maxlength="50"
	validate="Clinical Notes,string,yes"
	value="<%=otSpecimenDispatchEntry.getClinicalNotes() %>" />

<div class="Clear"></div>
<div class="division"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>
<div class="Clear"></div>
<div class="Height10"></div>
<input type="button" name="Update" class="button" value="Update"
	onclick="submitForm ('specimenDispatchEntry','ot?method=updateOtSpecimenDispatchEntry')" />
<input type="button" name="Back" class="button" value="Back"
	onclick="submitForm ('specimenDispatchEntry','ot?method=showSpecimenDispatchEntry')" />

<input name="userName" id="userName" type="hidden"
	value="<%=userName %>" /> <input name="hinId" type="hidden"
	value="<%=otSpecimenDispatchEntry.getHin().getId()%>" /> <input
	name="departmentId" type="hidden"
	value="<%=otSpecimenDispatchEntry.getDepartment().getId()%>" /> <input
	name="visitId" type="hidden"
	value="<%=otSpecimenDispatchEntry.getVisit().getId()%>" /> <input
	type="hidden" name="orderNo" value="<%=patient.getOrderNo() %>" /> <input
	name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input
	name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
	name="changedTime" type="hidden" value="<%=currentTime %>" /> <input
	name="specimenId" type="hidden"
	value="<%=otSpecimenDispatchEntry.getId() %>" /></div>
<%} }%>
</form>
</div>

