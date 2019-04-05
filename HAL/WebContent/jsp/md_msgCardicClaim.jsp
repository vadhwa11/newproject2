
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<%
Map<String, Object> map = new HashMap<String, Object>();
String formName = "";
String hinNo = "";
String entryNo = "";

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("formName") != null){
	formName = (String)map.get("formName");
}
if(map.get("hinNo") != null){
	hinNo = (String)map.get("hinNo");
}
if(map.get("entrySeqNo") != null){
	entryNo = (String)map.get("entrySeqNo");
}
int id=0;
if(map.get("id") != null){
	id =Integer.parseInt(map.get("id").toString());
}
int serviceTypeId=0;
if(map.get("serviceTypeId") != null){
	serviceTypeId =Integer.parseInt(map.get("serviceTypeId").toString());
}
%>
<form name="msgCardicClaim" method="post">
<div id="contentHolder">
<% 

		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		System.out.println("id::::"+id);
		if(!message.equalsIgnoreCase("")){
		 %>
<h2><%=message %></h2>
<%} %>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<label class="noWidth"><span><%=message %></span></label>
<div class="Clear"></div>
<div class="Block"><input type="hidden" name="hinNo"
	value="<%=hinNo %>" /> <input type="hidden" name="entryNo"
	value="<%=entryNo %>" /> <input type="hidden" name="message"
	value="<%=message %>" /> <input type="hidden" name="Id"
	value="<%=id %>" /> 
	
	<label class="large">Covering Letter For
Cardiac Advance</label> <input type="radio" id="opdPrint" name="selectReport"
	checked="checked" value="1" tabindex="1" class="radioAuto" /> 
	
	<label class="large" >MedicalAdvance(Appendix
'D')</label> <input type="radio" id="opdPrint" name="selectReport" value="2"
	tabindex="1" class="radioAuto" />
<div class="Clear"></div>
<label class="large">Covering
Letter (Pre-Facto Sanction)</label> <input type="radio" id="opdPrint"
	name="selectReport" value="3" tabindex="1" class="radioAuto" /> <label
	class="large">WillingnessCertificate(Annexure
I)</label> <input type="radio" id="opdPrint" name="selectReport" value="4"
	tabindex="" class="radioAuto" />
<div class="Clear"></div>

<label class="large">Dependent Card</label>
<input type="radio" id="opdPrint" name="selectReport" value="6"
	tabindex="1" class="radioAuto" /> <label class="large">UndertakingDefencePersional
(Annexure II)</label> <input type="radio" id="opdPrint" name="selectReport"
	value="7" tabindex="1" class="radioAuto" />
<div class="Clear"></div>
<label class="large">Certificate By
Patient </label> <input type="radio" id="opdPrint" name="selectReport"
	value="8" tabindex="1" class="radioAuto" /> 
	<label class="large">Specialised Cardiac
Treatment (Treatment Authority)</label> <input type="radio" id="opdPrint"
	name="selectReport" value="10" tabindex="1" class="radioAuto" />

<div class="Clear"></div>
</div>

<div class="Clear"></div>
<input type="hidden" name="id" id="id" value="<%=id %>" /> <input
	type="hidden" name="serviceTypeId" id="serviceTypeId"
	value="<%=serviceTypeId %>" /> <!-- <input type="button" name="print" class="cmnButton" value="CoveringLetterForCardiacAdvance" onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printAdvanceCoveringLetter','checkTargetForYes');" />
<input type="button" name="print" class="cmnButton" value="MedicalAdvance(Appendix 'D')" onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printMedicalAdvance&hinNo'checkTargetForYes');" />
<input type="button" name="print" class="cmnButton" value="Annexure III (Certificate of AMA)" onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printAuthorisedmedicalAttendent','checkTargetForYes');" />
<input type="button" name="print" class="cmnButton" value="WillingnessCertificate(Annexure I)" onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printWillingnessCertificate','checkTargetForYes');" />
<div class="Clear"></div>
<input type="hidden" name="print" class="cmnButton" value="PrintUndertakingMedicalAdvance" onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printUndertakingMedicalAdvance&hinNo','checkTargetForYes');" />
<input type="button" name="print" class="cmnButton" value="DependentCard" onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printUndertakingIdentificationCardFamilies&hinNo','checkTargetForYes');" />
<input type="button" name="print"    class="cmnButton" value="UndertakingDefencePersional (Annexure II)" onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printCardiacUndertakingDefencePer'checkTargetForNo');" />
<input type="button" name="print"    class="cmnButton" value="Certificate The Patient Attandent" onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printCardiacCertificateToPatient','checkTargetForNo');" />-->
<input type="button" name="print" class="cmnButton" value="Print"
	onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=printCardiacClaimAdvanceReports','checkTargetForYes');" />
<input type="button" name="no" class="cmnButton" value="No"
	onclick="submitForm('msgCardicClaim','/hms/hms/mediClaim?method=showPatientCardicClaimAdvance','checkTargetForNo');" />
<div class="Clear"></div>


</div>
</form>
