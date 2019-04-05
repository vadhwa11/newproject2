<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>

<%@page import="jkt.hms.masters.business.PatientAllergicDrugsHd"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script> 
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
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

function getElements()
{
var a=1;
for(var i = 1; i < 8; i++){
if(document.getElementById('nomenclature'+i).value == "")
{
		a++;
}	

}
if(a==8)
{
alert("Please Enter nomenclature");
alert("enter the allergic drug to submit");
return false;
}else{
return true;
}
}
</script>
	<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

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
	 
	 List<PatientAllergicDrugsHd> searchPatientAllergicDrugsHdList = new ArrayList<PatientAllergicDrugsHd>();
		if(map.get("searchPatientAllergicDrugsHdList") != null){
			searchPatientAllergicDrugsHdList=(List<PatientAllergicDrugsHd>)map.get("searchPatientAllergicDrugsHdList");
		}	
		if(searchPatientAllergicDrugsHdList.size() > 0){
			
		%>
		
		
<!--main content placeholder starts here-->
<div id="contentHolder">
	<form name="patientAD" action="" method="post">
	
	<input type="hidden" value="<%=visit.getId()%>"/>
	<input type="hidden" id="patientAllergicDrugshdId"  value="<%= patientAllergicDrugsHd.getId()%>"  />
	<input type="hidden" id="hinId" value="<%= hinId%>"  />
	<input type="hidden" name="<%=DEPARTMENT_ID %>"  value="<%=visit.getDepartment().getId() %>" />
	<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
	
	
	<%if(visit.getDepartment()!= null){ %>
	<h6>Patient Allergic Drugs</h6>
	<div class="Clear"></div>
	<%} %>	

<!--Block One Starts-->

	<div class="blockTitle">Service Personnel Details</div><div class="blockTitleCurve"></div>
	<div class="Clear"></div>
	
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label>
<%if(visit.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<label class="medium">Service No.</label>
<%if(visit.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<label class="medium"> Serv. Status </label>
<%if(visit.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Name</label>
<%if(patientName != null){ %>
<label class="value"><%=patientName %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<div class="Clear"></div>

<label class="medium">Relation</label>
<%if(visit.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<label class="medium">Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>




<label class="medium">Unit</label>
<%if(visit.getHin().getUnit()!= null && !visit.getHin().getUnit().getUnitName().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Unit Address</label>
<% if(visit.getHin().getUnit()!= null&& !visit.getHin().getUnit().getUnitAddress().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<div class="Clear"></div>

<div class="division"></div>
<div class="blockTitle">Patient Details</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label>
<%if(visit.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getHinNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Age</label>
<%if(visit.getHin().getAge()!= null){ %>
<label class="valuemedium"><%=HMSUtil.calculateAge(visit.getHin().getAge() , visit.getHin().getRegDate(), visit.getHin().getDateOfBirth()) %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Visit Date </label>
<%if(visitDateInString != null){ %>
<label class="valuemedium"><%=visitDateInString %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Visit no. </label>
<%if(visit.getVisitNo()!= null){ %>
<label class="valuemedium"><%=visit.getVisitNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<div class="Clear"></div>


<label class="medium">Token No. </label>
<%if(visit.getTokenNo()!= null){ %>
<label class="valuemedium"><%=visit.getTokenNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>	

<label class="medium">ECHS No. </label>
<%if(visit.getHin().getEchsNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getEchsNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>	



<label class="medium">Patient Name</label>
<%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label>
<%}else{ %>
<label class="value">- </label>
<%} %>


<label class="medium">Prev. Diag </label>
<%if(visit.getDiagnosis()!= null){ %>
<label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %>
<label class="valueNoWidth">-</label>
<%} %>

	<div class="Clear"></div>
	
	<label class="medium">Phone No.</label>
	<% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
	<label class="valuemedium"><%=visit.getHin().getPhoneNumber() %></label>
	<%}else{ %>
	<label class="valuemedium">---</label>
	<%} %>
		
	<label class="medium">Mobile No.</label>
	<% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
	<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
	<%}else{ %>
	<label class="valuemedium">---</label>
	<%} %>
</div>

<!--Block one Ends-->
<div class="Clear"></div>    

<label class="valueNoWidth"><span>Details have been submitted for the patient.</span></label>
<div class="Clear"></div>
 
<div class="Clear"></div>


<input  type=hidden value=0 name=pagecounter2 />
<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>">
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>">
<input type="hidden" size="2" value=""  name="noOfRecords" id="noOfRecords" />
<div class="division"></div>

<div class="bottom">
<input type="button" class="button" value="View"  onclick="submitForm('patientAD','opd?method=viewPatientAllergicDrug&viewScreen=no');"/>
<!--  <input type="button" class="button" value="View"  onclick="submitForm('patientAD','opd?method=viewPatientAllergicDrug&flag=prev&viewScreen=no');"/> -->
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="submitForm('patientAD','opd?method=showOPDMainJsp&visitId=<%=visit.getId()%>&deptId=<%=visit.getDepartment().getId()%>');"  align="right"/>
<div class="Clear"></div>
<label>Changed By</label>  
<label class="value"><%=userName %></label>

<label>Changed Date</label>   
<label class="value"><%=date%></label>
			 
<label>Changed Time</label>   
<label class="value"><%=time%></label>

<div class="Clear"></div>
</div>


</form>
</div>
		
<%
}else{

%>


<!--main content placeholder starts here-->
<div id="contentHolder">
	<form name="patientAD" action="" method="post">
	
	<input type="hidden" value="<%=visit.getId()%>"/>
	<input type="hidden" id="patientAllergicDrugshdId"  value="<%= patientAllergicDrugsHd.getId()%>"  />
	<input type="hidden" id="hinId" value="<%= hinId%>"  />
	<input type="hidden" name="<%=DEPARTMENT_ID %>"  value="<%=visit.getDepartment().getId() %>" />
	<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
	
	
	<%if(visit.getDepartment()!= null){ %>
	<h6>Patient Allergic Drugs</h6>
	<div class="Clear"></div>
	<%} %>	

<!--Block One Starts-->

	<div class="blockTitle">Service Personnel Details</div><div class="blockTitleCurve"></div>
	<div class="Clear"></div>
	
<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label>
<%if(visit.getHin().getServiceType()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<label class="medium">Service No.</label>
<%if(visit.getHin().getServiceNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<label class="medium"> Serv. Status </label>
<%if(visit.getHin().getServiceStatus()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getServiceStatus().getServiceStatusName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Name</label>
<%if(patientName != null){ %>
<label class="value"><%=patientName %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<div class="Clear"></div>

<label class="medium">Relation</label>
<%if(visit.getHin().getRelation() != null){ %>
<label class="valuemedium"><%=visit.getHin().getRelation().getRelationName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<label class="medium">Rank</label>
<%if(visit.getHin().getRank()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getRank().getRankName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>




<label class="medium">Unit</label>
<%if(visit.getHin().getUnit()!= null && !visit.getHin().getUnit().getUnitName().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Unit Address</label>
<% if(visit.getHin().getUnit()!= null&& !visit.getHin().getUnit().getUnitAddress().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<div class="Clear"></div>
<label class="medium">Tel No.</label>
<% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<div class="division"></div>
<div class="blockTitle">Patient Details</div><div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label>
<%if(visit.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getHinNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Age</label>
<%if(visit.getAge()!= null){ %>
<label class="valuemedium"><%=visit.getAge() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Visit Date </label>
<%if(visitDateInString != null){ %>
<label class="valuemedium"><%=visitDateInString %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>

<label class="medium">Visit no. </label>
<%if(visit.getVisitNo()!= null){ %>
<label class="valuemedium"><%=visit.getVisitNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>
<div class="Clear"></div>


<label class="medium">Token No. </label>
<%if(visit.getTokenNo()!= null){ %>
<label class="valuemedium"><%=visit.getTokenNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>	

<label class="medium">ECHS No. </label>
<%if(visit.getHin().getEchsNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getEchsNo() %></label>
<%}else{ %>
<label class="valuemedium">-</label>
<%} %>	



<label class="medium">Patient Name</label>
<%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label>
<%}else{ %>
<label class="value">- </label>
<%} %>


<label class="medium">Prev. Diag </label>
<%if(visit.getDiagnosis()!= null){ %>
<label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %>
<label class="valueNoWidth">-</label>
<%} %>

<div class="Clear"></div>

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
</script>

<input  type=hidden value=0 name=pagecounter2 />
<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>">
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>">
<input type="hidden" size="2" value=""  name="noOfRecords" id="noOfRecords" />
<div class="division"></div>
<div class="tableHholderCmnLarge">
<table width="100%" colspan="7" id="chargeDetails"  cellpadding="0" cellspacing="0">
<thead>
<tr> 

<th width="10%">Nomenclature</th>
<th width="7%">PVMS No</th>
<th width="7%">Special Instruction</th>
</tr>
</thead>
<tbody>
<%
int detailCounter=5; 
int temp=0;
int inc = 0;    	
if(pageNo!=1)
{
temp=detailCounter*(pageNo-1);
} 
for(inc=1;inc<=8;inc++){
%>

<tr> 

<input type="hidden" size="2"	value="<%=temp+inc%>"  name="<%=SR_NO%>" readonly="readonly" />
    
	<td width="10%">    		
		<input type="text" value=""  size="80" validate="Nomenclature,string,no"	tabindex="1" id="nomenclature<%=inc%>" name="nomenclature<%=inc%>" onblur="if(fillSrNo('<%=inc %>')){checkForNomenclature(this.value, '<%=inc %>');}"  />
			<div id="ac2update" style="display:none; border:1px solid black; padding-right: 550px; background-color:white;overflow: scroll;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','opd?method=getItemList',{parameters:'requiredField=nomenclature<%=inc%>&visitId=<%=visit.getId()%>'});
			</script>				
	</td>
   	<td>
	  <input type="text"   name="<%=PVMS_NO %>"  id="pvmsNo<%=inc%>"  validate="PVMS No.,string,no" readonly />
	</td>
	
	<input type="hidden" value="" name="<%=ITEM_ID%>" id="itemId<%=inc %>" />
	<td width="7%">
		<input type="text" id="instructions<%=inc%>" maxlength="30" tabindex="1" size="50" name="<%=INSTRUCTIONS %>" value=""/>
		
	</td>
	
</tr>

<%}%>

</tbody>
</table>


</div>
<div class="bottom">
<input type="hidden" name="counter" id="counter" value="<%=inc %>"/>
<input type="hidden" class="button" value="Next"  onclick="if(checkForNext()){submitForm('patientAD','opd?method=addPatientAllergicDrugs&buttonFlag=next');}" align="right" />
<input type="button"  class="button" value="Add" name="Submit1" id="Submit1" onclick="submitForm('patientAD','opd?method=addPatientAllergicDrugs','getElements');" align="right" />
 <input type="button" class="button" value="View"  onclick="submitForm('patientAD','opd?method=viewPatientAllergicDrug&viewScreen=no');"/>
<!--  <input type="button" class="button" value="View"  onclick="submitForm('patientAD','opd?method=viewPatientAllergicDrug&flag=prev&viewScreen=no');"/> -->
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="submitForm('patientAD','opd?method=showOPDMainJsp&visitId=<%=visit.getId()%>&deptId=<%=deptId%>');"  align="right"/>
<div class="Clear"></div>
<label>Changed By</label>  
<label class="value"><%=userName %></label>

<label>Changed Date</label>   
<label class="value"><%=date%></label>
			 
<label>Changed Time</label>   
<label class="value"><%=time%></label>

<div class="Clear"></div>


</div>


</form>
</div>
<%} %>

<script type="text/javascript">

function checkForNext(){
	if(document.getElementById('noOfRecords').value<8)
		{
		alert("All rows are not filled.Please Select the Test Code to Enter ")
		return false;
		}else{
	return true;
}
}
 function fillSrNo(rowVal){
		
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
   			rowVal=rowVal%8
   			if(rowVal==0){
   				rowVal=8
   	 			}
   		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	return true;
}

 function checkForNomenclature(val,inc){
	
		if(val != "")
		{
		var pageNo =parseInt(document.getElementById('pageNo').value) 
		var start=((pageNo-1)*8)+1;
    	var end=((pageNo-1)*8)+8;
    	
	    var index1 = val.lastIndexOf("[");
	    var indexForNomenclature=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForNomenclature=indexForNomenclature--;
	    var nomenclature=val.substring(0,indexForNomenclature);
	    
	     if(pvmsNo =="")
	    {
	    
	     return;
	    }
	    for(i=1;i<inc;i++){
	    
	      if(inc != 1){
	        if(document.getElementById('nomenclature'+i).value==val)
	        {
	    		alert("Item already selected...!")
	    		document.getElementById('nomenclature'+inc).value=""
	    	
	    	  return false;
	        }
	      }  
	   }
	   	
		ajaxFunctionForAutoCompleteNomenclature('patientAD','opd?method=fillItemsInGrid&pvmsNo='+pvmsNo , inc);
	  }
	}
</script>