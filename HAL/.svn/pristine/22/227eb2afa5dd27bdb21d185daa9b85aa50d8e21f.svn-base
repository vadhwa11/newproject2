<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
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


<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
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
		int orderhdId = 0;
		String buttonFlag="";
		int pageNo=1;
		List itemList = new ArrayList();
	 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			


	 List searchPatientAllergicDrugsDtList = new ArrayList();
		
		if(map.get("searchPatientAllergicDrugsDtList") != null){
			searchPatientAllergicDrugsDtList=(List)map.get("searchPatientAllergicDrugsDtList");
		}			

		
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");

	}
	
	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	 
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	
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
	 
	 if(map.get("pageNo") != null)
	 {
	 pageNo=(Integer)map.get("pageNo");

	 }
	
	 PatientAllergicDrugsHd patientAllergicDrugsHd= new PatientAllergicDrugsHd();
	 
	 if(detailsMap.get("itemList") != null){
		 itemList = (List)detailsMap.get("itemList");
		 }
	 
	 if(map.get("orderhdId") != null)
	 {
	 orderhdId=(Integer)map.get("orderhdId");

	 }

%>


<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="patientAD" action="" method="post"><input
	type="hidden" value="<%=visit.getId()%>" /> <input type="hidden"
	id="patientAllergicDrugshdId"
	value="<%= patientAllergicDrugsHd.getId()%>" /> <input type="hidden"
	id="hinId" value="<%= hinId%>" /> <input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />
<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%if(visit.getDepartment()!= null){ %>
<h6>Patient Allergic Drugs</h6>
<div class="Clear"></div>
<%} %> <!--Block One Starts-->
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
</div>

<!--Block one Ends-->

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
	name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <input
	type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>" /> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
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
<div class="division"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden" name="counter"
	id="counter" />
<div class="Clear"></div>
</div>
<% }else  {%>

<div class="bottom"><label class="noWidth">No Records
found!</label></div>

<%} %>
<div class="Clear"></div>
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /></form>
</div>

