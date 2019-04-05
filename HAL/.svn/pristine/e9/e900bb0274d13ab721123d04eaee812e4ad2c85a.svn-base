<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

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
<script type="text/javascript">
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- 
Include the WYSIWYG javascript files
-->
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/wysiwyg-color.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/wysiwyg-settings.js"></script>
<!-- 
Attach the editor on the textareas
-->
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('abc', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>


<script type="text/javascript">
function blankSpace()
{
var b1 = document.getElementById('upload').value ;
var b2 = document.getElementById('abc').value ;
var b3= document.getElementById('b3').value ;
if((b1=="")&&(b2=="")&&(b3==""))
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
<script type="text/javascript">

function see()
{
opdTemplateDepartmentWise.method = "post";
fName=document.getElementById("upload").value;
var extension =fName.substring(fName.length-4);
if(extension!='.htm')
{
alert("Incorrect file only take web files ");
document.getElementById("upload").value="";
return false;
}
	if(fName !=""){
		//if( extension != '.txt' && extension != '.TXT' && extension !='.rtf')
		//{	
		//	alert("Uploaded Document can only be in .txt or .TXT format\n");
		//	return false;
		//}
		var updatedtemplate= opdTemplateDepartmentWise.test2.value;
		opdTemplateDepartmentWise.browse.value="browse";
		submitForm('opdTemplateDepartmentWise','opd?method=getFileNameForOPD&browse=browse'); 
	}
return true;
}

function callback(http_request) {
if (http_request.readyState == 4 || http_request.readyState=="complete") {
alert('http_request.responseText'+http_request.responseText);
alert(document.getElementById("abc").value)
document.getElementById('abc').value=http_request.responseText;
}
}
function submitTemplate(){
	WYSIWYG.updateTextArea('abc');

	//var templateData =document.getElementById("abc").value;
	submitForm('opdTemplateDepartmentWise','opd?method=addOpdTemplateDepartmentWise','blankSpace');
}

</script>
<%
		Map<String, Object> map = new HashMap<String, Object>();

		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			session.setAttribute("map",map);
		}
		
	
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		int orderhdId = 0;
		String appendedHtml="";
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}

	
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");

	}
	if(map.get("appendedHtml") != null){
		appendedHtml =(String) map.get("appendedHtml");
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
	 
	
	 if(map.get("orderhdId") != null)
	 {
	 orderhdId=(Integer)map.get("orderhdId");

	 }
	 
	%>
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="opdTemplateDepartmentWise" action="" method="post"
	enctype="multipart/form-data"><input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />

<%if(visit.getDepartment()!= null){ %>
<h6>Opd Template Department Wise</h6>
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
	class="medium">Unit</label> <%if(visit.getHin().getUnit()!= null && !visit.getHin().getUnit().getUnitName().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitName() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %> <label
	class="medium">Unit Address</label> <% if(visit.getHin().getUnit()!= null&& !visit.getHin().getUnit().getUnitAddress().equals("")){ %>
<label class="valuemedium"><%=visit.getHin().getUnit().getUnitAddress() %></label>
<%}else{ %> <label class="valuemedium">-</label> <%} %>
<div class="Clear"></div>
<div class="division"></div>
<div class="blockTitle">Patient Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<label class="medium">HIN No.</label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valuemedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valuemedium">-</label> <%} %> <label class="medium">Age</label>
<%if(visit.getAge()!= null){ %> <label class="valuemedium"><%=visit.getAge() %></label>
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

<label class="medium">Phone Number</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %> <label
	class="medium">Mobile Number</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %>
</div>
<div class="Clear"></div>

<!--Block one Ends--> <label class="noWidth">Upload Text
Here(only .htm files)</label> <input type="file" id="upload"
	name="<%=UPLOAD_FILENAME%>" class="Browse" size="50" onchange="see()" />
<div class="Clear"></div>
<!--Rich text editor-->
<table border="0" cellpadding="2" cellspacing="0" width="100%">
	<tr>
		<td colspan="2">
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
			<tr>
				<td><textarea id="abc" name="test2" value=""
					class="tableTextareaEditor">
  <% if(map.get("content")!=null){ %>
    <%=map.get("content").toString() %>
    
   
  <%
   } %>
  </textarea></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<div id="hiddenTextArea" style="display: none"><textarea
	id="appendedHtml" name="appendedHtml"><%=appendedHtml %></textarea></div>
<!--Rich text editor ends-->


<div class="Clear"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="visitId" value="<%=visit.getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>"> <input
	type="hidden" id="browse" name="browse" value="" />
<div class="division"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName %>">
<div class="Clear"></div>
<input type="button" class="button" value="Submit"
	onclick="submitTemplate();" align="right" /> <input type="button"
	class="button" value="View"
	onclick="submitForm('opdTemplateDepartmentWise','opd?method=viewOpdTemplateDepartmentWise&flag=prev&viewScreen=no');" />
<input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="submitForm('opdTemplateDepartmentWise','opd?method=showOPDMainJsp&visitId=<%=visit.getId()%>&deptId=<%=deptId%>');"
	align="right" /></div>
</form>
</div>

