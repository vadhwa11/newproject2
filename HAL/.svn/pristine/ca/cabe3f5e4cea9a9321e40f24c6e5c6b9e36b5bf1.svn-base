
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />

<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String formName = "";
	String hinNo = "";
	String id="";
	int contigentMedicalBill_Id=0;
	int specialInvId=0;
	int entryNo = 0;
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	if(map.get("formName") != null){
		formName = (String)map.get("formName");
	}
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
	%>

<%} %>
<form name="message" method="post">
<div class="Clear"></div>
<%
		if(map.get("entrySeqNo") != null){
			id = (String) map.get("entrySeqNo");
		}
		if(map.get("hinNo") != null){
			hinNo = (String)map.get("hinNo");
		}
		
		if(map.get("entrySeqNqq") != null){
			entryNo = (Integer)map.get("entrySeqqqo");
		}
		if(map.get("contigentMedicalBill_Id") != null){
			contigentMedicalBill_Id = (Integer)map.get("contigentMedicalBill_Id");
		}
		
		if(map.get("specialInvId") != null){
			specialInvId = (Integer)map.get("specialInvId");
		}
	%>

<div class="Clear"></div>


<h4><%=message %></h4>
<div class="Clear"></div>
<div class="Block"><input type="hidden" name="specialInvId"	value="<%=specialInvId %>" />
 <input type="hidden" name="contigentMedicalBill_Id" value="<%=contigentMedicalBill_Id %>" />
<input type="hidden" name="message" value="<%=message %>" /> 
<%---
<label	class="large">Print Certificate By Registrar</label>
<input type="radio" id="opdPrint" name="selectReport" checked="checked"	value="1" tabindex="1" class="radio" /> --%>
<div class="Clear"></div>
<label class="large">Print Contingent Bill Rembersements</label> 
<input type="radio" id="opdPrint" name="selectReport" value="2" tabindex="1" class="radio" />
<div class="Clear"></div>
<label class="large">Print Dependent Card</label> 
<input type="radio" id="opdPrint" name="selectReport" value="3" tabindex="1" class="radio" />
<div class="Clear"></div>
</div>
<!-- <input type="button" name="report1" value="Print Certificate By Registrar" class="cmnButton" onclick="submitForm('message','/hms/hms/mediClaim?method=printCertificateByRegistrar&specialInvId','checkTargetForYes');"/>
	<input type="button" name="report2" value="Print Contingent Bill Rembersements" class="cmnButton" onclick="submitForm('message','/hms/hms/mediClaim?method=printContingentBillRem&contigentMedicalBill_Id','checkTargetForYes');"/>
	<input type="button" name="report3" value="Print Identification Card" class="cmnButton" onclick="submitForm('message','/hms/hms/mediClaim?method=printIdentificationCard&contigentMedicalBill_Id','checkTargetForYes');"/>-->
<input type="button" name="yes" value="Print" class="button"
	onclick="submitForm('message','/hms/hms/mediClaim?method=printGeneralClaimReports','validateRadio');" />
<input type="button" name="no" value="No" class="button"
	onclick="submitForm('message','/hms/hms/mediClaim?method=showUpdateSearchForSpecialInvetigationJsp');" />
<div class="Clear"></div>

</div>
</form>
<script>
function validateRadio(){
	
	 for(var i = 0; i < document.getElementsByName('selectReport').length; i++){
	  if(document.getElementsByName('selectReport')[i].checked == true)
     {
		return true;
	  }		
	}
	alert("Please select a option to print")
	return false;

}
</script>