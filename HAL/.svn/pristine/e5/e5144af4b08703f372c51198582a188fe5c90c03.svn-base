<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>

<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>

<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgTemplate"%>

<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	//alert(mlength);
	if (obj.getAttribute && obj.value.length>mlength)
		obj.value=obj.value.substring(0,mlength)
}

function fillOrganism(){
  var orGroupId ="";
   var x=document.getElementById("organismId")
	for (var i=0; i<x.options.length-1;i++) {
	if (x.options[i].selected) {
		orGroupId=orGroupId+x.options[i].value+"."
	
	}
}
	 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
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
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("organismDiv").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("sensitivityDiv").innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("organismDiv").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/investigation?method=getOrganismList&orGroupId="+orGroupId,true);
    
    xmlHttp.send(null);
//----------------------AJAX PART------------End------

}

function fillSensitivity(val){
var noOfOrg=document.getElementById("noOfOrg").value
 var x=document.getElementById("organismId")
 var orIds="";

	for (var i=1; i<=noOfOrg;i++) {
	
		if (document.getElementById(("chkBox"+i)).checked) {
			orIds=orIds+document.getElementById(("chkBox"+i)).value+"."
		}
	}
 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
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
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("sensitivityDiv").innerHTML='<font id="error">Loading...</font>'
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("sensitivityDiv").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/investigation?method=getSensitivityList&orIds="+orIds,true);
    
    xmlHttp.send(null);
//----------------------AJAX PART------------End------
}
  function resetResult(){
 
	   document.getElementById('abc').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
 function submitSensitivityData(){
 	if(checkForCheckBox()){
 		submitForm('sensitivity','investigation?method=saveSensitivity');
 	}
 }
 function checkForCheckBox(){
	 	if(document.sensitivity.screenSens[0].checked) {
		 	if(document.getElementById("noOfOrg") != null){
			 	var noOfOrg = document.getElementById("noOfOrg").value;
			 	if(noOfOrg != 0){
			 		if(document.getElementById("noOfSensitivity") != null){
				 		var noOfSensitivity=document.getElementById("noOfSensitivity").value;
				 		if(noOfSensitivity != 0){
					 		for (var i=1; i<=noOfSensitivity;i++) {
								if (document.getElementById(("chkBoxSensitive"+i)).checked) {
									return true;
								}
							}
							alert('Select atleast one sensitivity.');
							return false;
				 		}else{
				 			alert('Select organism that having sensitivity.');
				 			return false;
				 		}
			 		}else{
			 			alert('Select any organism.');
			 			return false;
			 		}
			 	}else{
			 		alert('Select organism group that having organism.');
			 		return false;
			 	}
		 	}else{
		 		alert('Select any organism group.');
		 		return false;
		 	}
	 	}else{
	 		return true;
	 	}
 }
 

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
int pageNo=1;
Map map = new HashMap();
Map<String,Object> utilMap = new HashMap<String,Object>();

List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<Patient> patientList = new ArrayList<Patient>();
List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();

utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

List inPatientDetailList = new ArrayList();
Box box = HMSUtil.getBox(request);

String userName = "";
try{
	   System.out.println("dgMasOrganismGroupList  JSp 1");
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
System.out.println("dgMasOrganismGroupList  JSp 2");
}catch(Exception ee){
	
}
if(map.get("pageNo") != null)
{
pageNo=(Integer)map.get("pageNo");
}
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
String message = (String)map.get("message");
out.println(message);
}
if(map.get("employeeList") != null){
employeeList = (List<MasEmployee>)map.get("employeeList");
}
int userId =0;
int resultEnteredBy =0;
int sampleCollectionDetailId =0;
if(session.getAttribute("userId") != null){
	userId = (Integer)session.getAttribute("userId");
}
if(map.get("investigationList") != null){
investigationList = (ArrayList)map.get("investigationList");
}
Map detailsMap1 = new HashMap();
Map detailsMap = new HashMap();
String resultSeqNo = "";
String CombinedIds = "";

if(map.get("detailsMap") !=null){
	detailsMap=(Map<String, Object>)map.get("detailsMap");
}

if(map.get("detailsMap1") !=null){
	detailsMap1=(Map<String, Object>)map.get("detailsMap1");
}

   if(detailsMap1.get("sampleCollectionDetailId") != null){
	   sampleCollectionDetailId  = (Integer)detailsMap1.get("sampleCollectionDetailId");
	}
   if(detailsMap1.get("resultEnteredBy") != null){
	   resultEnteredBy  = (Integer)detailsMap1.get("resultEnteredBy");
	}
   if(detailsMap1.get("resultSeqNo") != null){
	   resultSeqNo  = (String)detailsMap1.get("resultSeqNo");
	}
   if(detailsMap1.get("CombinedIds") != null){
	   CombinedIds  = (String)detailsMap1.get("CombinedIds");
	}
   if(detailsMap.get("dgMasOrganismGroupList") != null){
	   dgMasOrganismGroupList  = (List<DgMasOrganismGroup>)detailsMap.get("dgMasOrganismGroupList");
	}
 
String deptName="";
if(session.getAttribute("deptName") != null){
	deptName = (String)session.getAttribute("deptName");
}
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
String deptType="";
if(session.getAttribute("deptType") != null){
	deptType = (String)session.getAttribute("deptType");
}

try{
if(map.get("sampleCollectionList") != null){
sampleCollectionList=(List)map.get("sampleCollectionList");

}
}catch(Exception e){
e.printStackTrace();
}


int hospitalId = 0;
MasRelation masRelation = new MasRelation();
DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
Patient patient = new Patient();
MasRank masRank = new MasRank();
String admissionNumber = "";
int departmentId =0;
int inpatientId =0;
int hinId = 0;
Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
if(sampleCollectionList != null)
{
dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
inpatientSet=patient.getInpatients();
masRank = (MasRank) patient.getRank();

}
MasDepartment masDepartment=new MasDepartment();
Patient pat = new Patient();
DgSampleCollectionDetails dgsampleDetails=new DgSampleCollectionDetails();

if(sampleCollectionList != null){
dgsampleDetails = (DgSampleCollectionDetails) sampleCollectionList.get(0);

}
%>

<!--main content placeholder starts here-->
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />

<div id="contentHolder">
<form name="sensitivity" method="post" action="">
<h6>Result Entry-Sensitivity</h6>
<div class="Clear"></div>
<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;
String hinNo="";

for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
if(dgCollection.getInvestigation().getChargeCode().getSubChargecode()!= null){
subDept = dgCollection.getInvestigation().getChargeCode().getSubChargecode().getSubChargecodeName();
dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
SubChargeId=dgCollection.getInvestigation().getChargeCode().getSubChargecode().getId();
mainChargeId=dgCollection.getInvestigation().getChargeCode().getSubChargecode().getMainChargecode().getId();
hinNo = dgCollection.getSampleCollectionHeader().getHin().getHinNo();
%> <%
}
}%> <input name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
	type="hidden" value="<%=SubChargeId %>" /> <input
	name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
	type="hidden" value="<%=mainChargeId %>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_ID %>" id="<%= SAMPLE_COLLECTION_ID%>"
	value="<%=dgDetails.getSampleCollectionHeader().getId() %>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
<input type="hidden" name="<%=HIN_NO %>"
	value="<%=patient.getHinNo() %>" /> <%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %>
<input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
<%}else{ %> <input type="hidden" name="<%=INPATIENT_ID %>" value="" /> <%} %>



<input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
	value="<%=date%>" /> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="<%=RESULT_NO %>" value="<%=resultSeqNo %>" /> <input
	type="hidden" name="<%= RESULT_ENTERED_BY  %>"
	validate="Report Entered By,string,yes" value="<%=resultEnteredBy %>"
	tabindex=1> <input type="hidden" name="CombinedIds"
	validate="Report Entered By,string,yes" value="<%=CombinedIds%>"
	tabindex=1> <%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {
%> <input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <%} %>
<div class="Clear"></div>
<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <!-- Block Three Ends  -->
<div class="blockFrame"
	<div align="center">
		
		<label class = "valueNoWidth">Growth</label>
		<input type="radio" class="small" id="screenSens" name="screenSens" value="g"  checked="checked" onclick="showDiv();""/>
		<label class = "valueNoWidth">Other</label>
		<input type="radio" class="small" id="screenSens" name="screenSens" value="o" onclick="showDiv();" "/>
		</div></div>
<script type="text/javascript">
		function showDiv()
		{
		if(document.sensitivity.screenSens[0].checked)
		{
		
			if(document.getElementById("growthDiv").style.display=="none")
				{
					document.getElementById("otherDiv").style.display="none";
					document.getElementById("growthDiv").style.display="block";
					
				}
		}
		if(document.sensitivity.screenSens[1].checked)
		{
	
			if(document.getElementById("otherDiv").style.display=="none")
				{
					
					document.getElementById("growthDiv").style.display="none";
					document.getElementById("otherDiv").style.display="block";
					
				}
		}
		
		}
		</script> <!--  -->
<div class="Clear"></div>
<div class="division"></div>
<div class="tableHolderAuto">
<table border="0" cellspacing="0" width="100%" cellpadding="0">

	<tr>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width=7%>Sample</th>
		<th scope="col">Diag No.</th>
		<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
		<th scope="col">Radio No.</th>
		<%}%>

		<th scope="col">Test Name</th>

		<%

Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
Set<DgTemplate> templateSet= new HashSet<DgTemplate>();
DgMasInvestigation masInv = new DgMasInvestigation();
String normalValue="";
String charge="";
int chargeId=0;
int investigationId=0;
String resultType="";
String result="";
int i =0;
for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
masInv = dgCollection.getInvestigation();
templateSet = masInv.getDgTemplates();

if(dgCollection.getInvestigation().getChargeCode()!= null)
{
charge=dgCollection.getInvestigation().getChargeCode().getChargeCodeName();
chargeId=dgCollection.getInvestigation().getChargeCode().getId();
investigationId =dgCollection.getInvestigation().getId();
resultType = dgCollection.getInvestigation().getInvestigationType();
System.out.println("... resultType ,.... "+resultType);
}
 

i++;

%>

		<tr>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td>
			<%if(dgCollection.getSample() != null){ %> <label
				name=<%=SAMPLE_CODE %> id=<%=SAMPLE_CODE %>><%=dgCollection.getSample().getSampleDescription() %></label>
			<%}else{ %> <label name=<%=SAMPLE_CODE %> id=<%=SAMPLE_CODE %>>-</label>
			<%} %>
			</td>
			<%} %>
			<td>
			<%if(dgCollection.getDiagNo() != null){ %> <label
				name=<%=DIAGNOSIS_NO %> id=<%=DIAGNOSIS_NO %>><%=dgCollection.getDiagNo() %></label>
			<%}else{ %> <label name=<%=DIAGNOSIS_NO %> id=<%=DIAGNOSIS_NO %>>-</label>
			<%} %>
			</td>
			<td><input name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %>"
				value="v" type="hidden"> <input
				name="<%=INVESTIGATION_ID %>" id="<%=INVESTIGATION_ID %>"
				value=<%= investigationId%> type="hidden"> <input
				name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID %>"
				value=<%= chargeId%> type="hidden"> <input
				name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %>"
				value=<%= dgCollection.getId()%> type="hidden"> <input
				name="<%=TEST_ORDER_NO_SENSITIVE_VALUE%>"
				id="<%=TEST_ORDER_NO_SENSITIVE_VALUE%>"
				value=<%= dgCollection.getInvestigation().getTestOrderNo()%>
				type="hidden"> <%if(dgCollection.getInvestigation().getInvestigationName() !=null){
%> <label><%=dgCollection.getInvestigation().getInvestigationName() %></label>
			<input name="<%=INVESTIGATION_NAME %>" type="hidden"
				value="<%=dgCollection.getInvestigation().getInvestigationName() %>"
				readonly /> <%}else { %> <label>-</label> <input
				name="<%=INVESTIGATION_NAME %>" type="hidden" value="" readonly /> <%} %>
			<%} %>
			
		</tr>
</table>
</div>
<div id="otherDiv" style="display: none;">
<div class="Clear"></div>
<div
	style="width: 450px; height: 150px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Result 1</th>

	</tr>
	<tr>
		<td><textarea name="result1" maxlength="400"
			onkeyup="return ismaxlength(this)"></textarea></td>

	</tr>

</table>
</div>
</div>

<div
	style="width: 450px; height: 150px; float: left; border: 1px solid #3C8AD7; margin-left: 20px; display: inline; overflow: auto;">
<div class="clear"></div>
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Result 2</th>
	</tr>
	<tr>
		<td><textarea name="result2" maxlength="400"
			onkeyup="return ismaxlength(this)"></textarea></td>
	</tr>
</table>
</div>
</div>
<div class="division"></div>
</div>


<!--  -->
<div id="growthDiv" style="display: block;">
<div class="Clear"></div>
<div
	style="width: 320px; height: 150px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Organism Group</th>
	</tr>
	<tr>
		<td><select name="organism" id="organismId" class="list"
			multiple="multiple" size="10" validate="Result Entered By,string,no"
			tabindex=1 onchange="fillOrganism();">
			<%for(DgMasOrganismGroup dgMasOrganismGroup : dgMasOrganismGroupList ){ %>
			<option value="<%=dgMasOrganismGroup.getId() %>"><%=dgMasOrganismGroup.getOrganismGroupName() %></option>
			<%} %>
		</select></td>
	</tr>
</table>
</div>
</div>

<!--Start of Organism Div-->
<div id="organismDiv">
<div
	style="width: 585px; border: 1px solid #3C8AD7; height: 150px; float: left; margin-left: 20px; display: inline; overflow: auto;">
<div class="auto">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="8%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Organism</th>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td width="9%">&nbsp;</td>
		<td width="71%">&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

</table>

</div>
</div>
</div>
<!--End of Organism Div-->
<div class="Clear"></div>
<div class="division"></div>

<div
	style="width: 585px; border: 1px solid #3C8AD7; height: 150px; float: left; margin-right: 20px; display: inline; overflow: auto;">
<div class="auto"><!--Start of Sensitivity Div-->
<div id="sensitivityDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="7%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Sensitivity</th>
		<th width="12%" scope="col">&nbsp;</th>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td width="9%">&nbsp;</td>
		<td width="72%">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
<!--End of Organism Div--></div>



</div>
</div>
<!--  -->



<div
	style="width: 320px; height: 140px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Remarks</th>
	</tr>
	<tr>
		<td>
		<%if(dgDetails.getRemarks() != null && dgDetails.getRemarks() !=""){ %>
		<textarea name="remarks" maxlength="100"
			onkeyup="return ismaxlength(this)"><%=dgDetails.getRemarks() %></textarea>
		<%}else{ %> <textarea name="remarks" maxlength="100"
			onkeyup="return ismaxlength(this)"></textarea> <%}%>
		</td>
	</tr>
</table>
</div>
</div>
<div class="Clear"></div>
<div class="division"></div>

<div
	style="width: 320px; height: 54px; float: left; border: 1px solid #3C8AD7;">
<div class="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" colspan="2">NOSOCOMIAL</th>
	</tr>
	<tr>
		<td><label class="valueNoWidth">Yes</label> <input type="radio"
			class="small" checked="checked" name="NOSOCOMIAL" value="Y">
		</td>
		<td><label class="valueNoWidth">No</label> <input type="radio"
			class="small" name="NOSOCOMIAL" value="N"></td>
	</tr>
</table>
</div>
</div>



<br />
<br />
<br />

<div class="Clear"></div>
<!-- Table Ends --> <!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="Clear"></div>

<input type="button" class="cmnButton" value="Submit" id="addbutton"
	onclick="submitSensitivityData();" align="right" /> <input
	name="Reset" type="button" id="reset" class="cmnButton" value="Reset"
	onclick="resetResult();" /> <input name="Button" type="button"
	class="cmnButton" value="Back" onclick="history.back();" /></div>
</form>
<!--Bottom labels starts--> <!--main content placeholder ends here--></div>