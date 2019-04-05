<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>OPD Case Sheet</h2>
</div>
<div class="clear"></div>

<form name="search"  method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Employee No. </label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	 MAXLENGTH="30"	onblur="if(validateMetaCharacters(this.value)){getHinNo('search','opd?method=getHinNoForpatientpres&flag=opd')}" />

<div id="hinDiv">
<label> Patient Name </label>
<input	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"	onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','opd?method=getvisitDetails')}"	 />
</div>
<label>Visit No for OPD</label>
<div id="testDiv"> 
<input type="text" id="visitNo" name="<%=VISIT_NUMBER%>" value="" class="date" MAXLENGTH="6" validate="Visit No.,String,yes" />

</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Case Sheet" class="button"
	onClick="submitForm('search','opd?method=showOpdCaseSheetReport&flagPrint=opd');" />
<input type="button" name="OK" value="Opd Question Print" class="button"
	onClick="submitForm('search','opd?method=showOpdCaseSheetReport&flagPrint=opdQuestion');" id="psyReport" style="display: none;"/>

	
<input name="
Ophthalmology Details" value="Ophthalmology Details" id="ophthalReport" class="button" onclick="submitForm('search','opd?method=showPatientEyeDetailsReport');" type="button" style="display: none;">
	
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

<%String eyeDeptCode=  HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentCodeForEye");
  String psychiatristDeptCode = HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentCodeForPhychiatrist");
%>
<script>
function populateSpecialityWiseButton(visitString)
{
 var arr= visitString.split("@");
 if(arr[2]=="<%=eyeDeptCode%>")
	 {

	   document.getElementById("ophthalReport").style.display = 'block';
	 document.getElementById("psyReport").style.display ="none";
	
	 }
 else if(arr[2]=="<%=psychiatristDeptCode%>")
	 {
	 document.getElementById("psyReport").style.display ="block";
	 document.getElementById("ophthalReport").style.display ="none";
	 }
 else
	 {
	 document.getElementById("psyReport").style.display ="none";
	 document.getElementById("ophthalReport").style.display ="none";
	 }
}
</script>


