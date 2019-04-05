<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
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
<script src="/hms/jsp/js/prototype.js" type="text/javascript">

</script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
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
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
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

	 

%>

<!--main content placeholder starts here-->
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<div id="contentHolder">
<form name="urologyCaseSheet" action="" method="post">
<input type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" /> 
<%if(visit.getDepartment()!= null){ %>
<h6>Urology Case Sheet</h6>
<div class="Clear"></div>
<%} %> 
<!--Block One Starts-->

<div class="blockTitle">Service Personnel Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="blockFrame">
<div class="Clear"></div>
<label class="medium">Service </label> 
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

<label style="padding-left:5px;width:100px;">Phone Number</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %> <label
	style="padding-left:5px;width:100px;">Mobile Number</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valuemedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valuemedium">---</label> <%} %>
<div class="Clear"></div>
</div>

<!--Block one Ends-->
<div class="Clear"></div>

<!--Block two Start-->
<div class="blockFrame">
<label>Symptoms</label> <textarea id="b1"
	rows="2" cols="" maxlength="1000" onkeyup="return ismaxlength(this)"
	name="<%=SYMPTOMME %>"></textarea>
<div class="Clear"></div>
</div>
<div class="blockTitle">Haematuria :</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>

<table ><tr>
     	<td><label style="width:50px;">Total :</label>
     		<select name="<%=HAE_TOTAL %>"  class="small" size="0" tabindex="2" >
     	    <option value="">Select</option>
     	    <option value="y">Yes</option>
			<option value="n">No</option>
		    </select>
	    </td><td>
	        <label style="width:70px;">Terminal :</label>
		    <select name="<%=HAE_TERIMINAL %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
	       </select>
	   </td><td> 
	        <label style="width:70px;">Initial :</label>
	        <select name="<%=HAE_INITIAL %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select>
		</td><td>
			<label style="width:70px;">Clots :</label> 
	        <select name="<%=HAE_CLOTS %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select>
		</td>
		</tr>
		</table>	
</div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="blockTitle">Pain :</div>
<div class="blockTitleCurve"></div>
<div class="blockFrame">
<div class="Clear"></div>

<table>
	<tr>
		<td>
			<label style="width:72px;">Left :</label>
			<select name="<%=URETERIC_LEFT %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select>
		</td><td>	
		    <label style="width:70px;">Right :</label> 
			<select name="<%=HAE_CLOTS %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select>
		</td>
	</tr>
</table>
</div>
<div class="Clear"></div>
	<div class="blockTitle">Hypogastric pain :</div>
	<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">

<table><tr>
	
	
			<td>	
			<label style="padding-left:1px;width:90px;">Hypogastric pain :</label>
			<select name="<%=HYPOGASTRIC_PAIN %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select>
		</td>
		<td>	
			<label style="padding-left:1px;width:90px;">Bone Pain :</label>
			<select name="<%=BONE_PAIN %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select> 
	    </td>
	    <td>	
			<label style="width:70px;">Dysuria :</label>
			<select name="<%=DYSURIA_PAIN %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select>
		</td>
		<td>	 
			<label style="width:170px;">Perineal / Rectal pain :</label>
			<select name="<%=PERINAL_RECTAL %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
		</td>
</tr></table>	
</div>
<div class="Clear"></div>
		<div class="blockTitle">Luts :</div>
			<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>
<table><tr>
			<td><label>Irritative</label></td>
			<td><label>Obstructive</label></td>
	   </tr>
	   <tr>
		   <td>
		  		<label style="width:70px;">Frequency</label>
		   		<select name="<%=L_FREQUENCY %>" size="0" value="y" tabindex="1" class="small">
		        <option value="">Select</option>
			    <option value="y">Yes</option>
				<option value="n">No</option></select>
		   </td>
		   <td>
		        <label style="width:70px;">Hesitanvy</label>
		        <select name="<%=L_HESITANVY %>" size="0" value="y" tabindex="1" class="small">
		        <option value="">Select</option>
			    <option value="y">Yes</option>
				<option value="n">No</option></select>
		   </td>
	   </tr>
	   <tr>
	   <td>
	  		<label style="width:70px;">Nocturia</label>
	   		<select name="<%=L_NOCTURIA %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
	   </td>
       <td>
            <label style="width:70px;">Straining</label>
            <select name="<%=L_STRAINING %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
       </td>	   
	   </tr>
	   <tr>
	   <td>
	   		<label style="width:70px;">Urgency</label>
	   		<select  name="<%=L_URGENCY %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
	   </td>
	   <td>
	        <label style="width:170px;">Sense of incomplete evaluation</label>
	        <select name="<%=L_SENSE_COM_EVA %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
	   </td>
	   </tr>
	   <tr>
	   <td>
	       <label style="width:70px;">Urge incontinence</label>
	  		<select name="<%=L_URGE_INCON %>"  size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
	   </td>
	   <td>
	        <label style="width:70px;">Intermittency</label>
	        <select name="<%=L_INTERMITTENCY %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select> 
	        
	   </td>
	   </tr>
	   <tr>
	   <td>
		    <label style="width:70px;">Dribbling</label>
		    <select name="<%=L_DRIBBLING %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
	   </td>
	   <td>
	   
	   </td>
	   </tr>

</table>
</div>

<div class="Clear"></div>
<div class="division"></div>
<div class="blockFrame">
<table><tr><td>
<label style="padding-left:5px;width:60px;">Calcularia </label> 
<select name="<%=CALCULARIA_CHECK %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select>
<input type="text" name="<%=CALCULARIA %>" />
</td><td> 
<label style="padding-left:5px;width:60px;">Chyluria </label>
<select name="<%=CHYLURIA_CHECK %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select> 
<input type="text" name="<%=CHYLURIA %>" />
</td><td> 
<label style="padding-left:5px;width:60px;">Erectile Dysfunction </label> 
<select name="<%=ERECTILE_DYSFUNCTION_CHECK %>"  size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option>
			</select> 
<input type="text" name="<%=ERECTILE_DYSFUNCTION %>">
</td></tr></table>


<div class="Clear"></div>

<label style="padding-left:3px;width:180px;">Ejaculatory Dysfunction :</label>
<div class="paddLeft83">
<table><tr><td>
<label style="width:90px;">Haemospermia</label>
<select name="<%=HAEMOSPERMIA %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
</td><td>			
<label style="width:100px;">Premature Ejaculation</label>			
<select name="<%=PREMATUREEJACULATION %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
</td><td>			
<label style="width:100px;">Retrograde Ejaculation</label>			 
<select name="<%=RETROGRADE_EJACULATION %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
</td><td>			  
<label style="width:100px;">Anejaculation Ejaculation</label>			
<select name="<%=ANEJACULATION_EJACULATION %>"" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
</td></tr></table>
</div>
<div class="Clear"></div>
<label>Incontinence :</label>
<div class="Clear"></div>
<div class="paddLeft83">
<table><tr><td>
<label style="width:90px;">Stress Incontinence</label>
<select name="<%=STRESS_INCONTINENCE %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
</td><td>			
<label style="width:100px;">Urge incontinence</label>			
<select name="<%=URGE_INCONTINENCE %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
</td><td>			 
<label style="width:100px;">Total incontinence</label>
<select name="<%=TOTAL_INCONTINENCE %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
</td><td>			 
<label style="width:100px;">Overflow incontinence</label>			
<select name="<%=OVERFLOW_INCONTINENCE %>" size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
</td></tr></table>			
</div>
<div class="Clear"></div>
<label style="padding-left:3px;width:180px;">Acute Urinary Retention :</label>

<select name="<%=ACUTE_URINARY_CHECK %>"  size="0" value="y" tabindex="1" class="small">
	        <option value="">Select</option>
		    <option value="y">Yes</option>
			<option value="n">No</option></select>
 <input type="text" name="<%=ACUTE_URINARY %>">

<div class="Clear"></div>
</div>
<!--Block two Ends--> 
<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> 
<input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> 
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>">
<div class="division"></div>

<div class="bottom">

<div class="Clear"></div>

<input type="button" class="button" value="Submit" onclick="submitForm('urologyCaseSheet','opd?method=addUrologyCaseSheet');" align="right" /> 
<input type="button" class="button" value="View" onclick="submitForm('urologyCaseSheet','opd?method=viewUrologyCaseSheet&flag=prev&viewScreen=no');" />
<input name="Back" type="button" src="images/phaseII/delete.gif" alt="Back" value="Back" class="button" onclick="history.go(-1);return false;" align="right" />
</div>
<div class="Height10"></div>
</form>
</div>