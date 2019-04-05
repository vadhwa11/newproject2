<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * transferByHinNo.jsp  
 * Purpose of the JSP -  This is for Transfer By HIN No.
 * @author  Ritu
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.9
--%>


<%@page import="jkt.hms.masters.business.DeliveryDetails"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.UserEmpGroup"%>
<%@page import="jkt.hms.masters.business.BabyDetails"%>


<%@page import="jkt.hms.masters.business.AllergyDetail"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.DeliveryDetails"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();

	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<BabyDetails> babyList = new ArrayList<BabyDetails>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTimeWithoutSc");



	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("deliveryDetailsList") != null){
		deliveryDetailsList = (List<DeliveryDetails>)map.get("deliveryDetailsList");
	}
	
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	
	if(map.get("babyList") != null){
		babyList = (List<BabyDetails>)map.get("babyList");
	}
	int otDepartmentId = 0;
	if(map.get("otDepartmentId") != null){
		otDepartmentId = (Integer)map.get("otDepartmentId");
	}
%>

<%if(deliveryDetailsList.size()>0) {
	int currentBedId = deliveryDetailsList.get(0).getInpatient().getBed().getId();
	String currentBedNo = deliveryDetailsList.get(0).getInpatient().getBed().getBedNo();
	System.out.println("hdh "+deliveryDetailsList.get(0).getInpatient().getBed().getBedNo() +currentBedNo);
	String patientName = "";

	String consultantName = "";
	int inpatientid = deliveryDetailsList.get(0).getInpatient().getId();
    DeliveryDetails DeliveryDetails = deliveryDetailsList.get(0);

if(DeliveryDetails.getInpatient().getHin().getPFirstName() != null)
{
patientName=DeliveryDetails.getInpatient().getHin().getPFirstName();
}
if(DeliveryDetails.getInpatient().getHin().getPMiddleName() != null)
	   {
	   patientName += " "+DeliveryDetails.getInpatient().getHin().getPMiddleName();
	   }
if(DeliveryDetails.getInpatient().getHin().getPLastName() != null)
	   {
	   patientName +=" "+DeliveryDetails.getInpatient().getHin().getPLastName();
	   }
if(DeliveryDetails.getInpatient().getDoctor() !=null){
	/* consultantName=inpatient.getDoctor().getRank().getRankName(); */
	if(DeliveryDetails.getInpatient().getDoctor().getFirstName() != null)
	{
		consultantName+=" "+DeliveryDetails.getInpatient().getDoctor().getFirstName();	
	}
	if(DeliveryDetails.getInpatient().getDoctor().getMiddleName() != null)
	{
		consultantName+= " "+DeliveryDetails.getInpatient().getDoctor().getMiddleName();
	}
	if(DeliveryDetails.getInpatient().getDoctor().getLastName() != null)
	{
		consultantName+=" "+DeliveryDetails.getInpatient().getDoctor().getLastName();
	}
}
%>
<h4>Mother Details</h4>
<div class="Block">

<label>Name</label> 
<label class="value"><%=patientName%></label>
<label>Employee No.</label> 
<label class="value"> <%=DeliveryDetails.getInpatient().getHin()!=null?DeliveryDetails.getInpatient().getHin().getServiceNo():"" %></label>

<label>Ward </label> <%if(DeliveryDetails.getInpatient() != null && DeliveryDetails.getInpatient().getHin()!=null){ %>
<label class="value"> <%=DeliveryDetails.getInpatient().getDepartment().getDepartmentName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>


<label>Admitting Doctor</label>
<label class="value"><%=consultantName %></label>

</div>
<div class="Clear"></div>

<div class="Block">
<h4>Delivery Notes</h4>

<label>Induction</label> <label class="value"><%=DeliveryDetails.getInduction()!=null?DeliveryDetails.getInduction():"" %></label>
<label>Augmentation</label><label class="value"><%=DeliveryDetails.getAugmentation()!=null?DeliveryDetails.getAugmentation():"" %></label>

<div class="clear"></div>
<div class="paddingTop5"></div>

<h4>Delivery Details</h4>
<label>Term of Gestation</label><label class="value"><%=DeliveryDetails.getGestation()!=null?DeliveryDetails.getGestation():"" %></label>

<div class="clear"></div>
<label>Episiotomy</label><label class="value"><%=DeliveryDetails.getEpisiotomy()%></label>


<label>Delivery Type</label><label class="value"><%=DeliveryDetails.getDeliveryType()%></label>

<label>Delivery Sub Type</label><label class="value"><%=DeliveryDetails.getDeliverySubType()%></label>


<label>Anesthesia</label><label class="value"><%=DeliveryDetails.getAnaesthesia()%></label>

<!-- <label><span>*</span> Perineal Tears</label>
<input type="text" id="perinealTears" name="perinealTears"	validate="Perineal Tears,string,no" tabindex="1" MAXLENGTH="250" />
<div class="clear"></div> -->
<label>Placenta & Membrane</label><label class="value"><%=DeliveryDetails.getPlacenta()%></label>


<label>Other Details</label><label class="value"><%=DeliveryDetails.getOtherDetails()%></label>

 
<label>Other Remarks</label><label class="value" style="width: 471px"><%=DeliveryDetails.getOtherRemarks()%></label>

</div>
<div class="Clear"></div>



<%
int j =1;
for(BabyDetails baby: babyList ) 
{%>

<h4>Baby <%=j++ %></h4>
<div class="Block">
<label>Birth Certificate No.</label><label class="value"><%=baby.getBirthCertificationNo()%></label>
<label>Live/Still Born</label><label class="value"><%=baby.getLiveStillBorn()%></label>
<label>Gender</label><label class="value"><%=baby.getSex().getAdministrativeSexName()%></label>
<div class="Clear"></div>

<label>DOB</label><label class="value"><%=baby.getDateOfBirth()%></label>
<label>Delivery Time</label><label class="value"><%=baby.getTimeOfBirth()!=null?baby.getTimeOfBirth():"" %></label>
<label>Birth Weight</label><label class="value"><%=baby.getWeight() !=null?baby.getWeight():"" %></label><div class="Clear"></div>

<label>Baby Cry</label><label class="value"><%=baby.getBabyCry()!=null?baby.getBabyCry():"" %></label>
<label>APGAR AT 1</label><label class="value"><%=baby.getApgarAt1()!=null?baby.getApgarAt1():"" %></label>
<label>APGAR AT 5</label><label class="value"><%=baby.getApgarAt5()!=null?baby.getApgarAt5():"" %></label><div class="Clear"></div>

<label>Complications</label><label class="value"><%=baby.getComplications()!=null?baby.getComplications():"" %></label>
<label>Anomalies</label><label class="value"><%=baby.getAnomalies()!=null?baby.getAnomalies():"" %></label>
<label>Baby Feeding</label><label class="value"><%=baby.getBabyFeeding()!=null?baby.getBabyFeeding():"" %></label><div class="Clear"></div>
</div>
<%} %>


<h4>Transfer Schedule</h4>
<form name="transferByHin" method="post">

<input type="hidden" name="otDepartmentId" value="<%=otDepartmentId%>"  id="otDepartmentId">
<input type="hidden" name="motherinpatientid" value="<%=inpatientid%>">

<div class="Block">
<label>Transfer Mother <span>*</span></label>
<select name="mothertoWard" validate='Mother Transfer,string,yes' onchange="submitProtoAjaxWithDivName('transferByHin','/hms/hms/appointment?method=getDoctorList&doctorIdName=mother','doctorList');checkBedForWard(this.value, <%=DeliveryDetails.getInpatient().getDepartment().getId()%>, <%=otDepartmentId%>, 'motherTransferDiv','motherbedNo','motherbedId','<%=currentBedNo%>','<%=currentBedId%>','motherBedDiv', 'motherwardId', 'doctorList', 'motherProcdure');" id="motherwardId">
<option value="0">Select</option>
<%for(MasDepartment department : departmentList){ 
     if(DeliveryDetails.getInpatient().getDepartment().getId()==department.getId())
     {
%>
          <option value="<%=department.getId()%>" selected>Back To ward</option>
       <%}else{ %>   
<option value="<%=department.getId()%>"><%=department.getDepartmentName()%></option>

<%}} %>
</select>
<input type="hidden" name="motherbedId" value="<%=currentBedId%>" id="motherbedId">

<span id="motherBedDiv">
<label> To Bed No. <span>*</span></label>
<input type="text" id="motherbedNo" readonly="readonly" validate='Mother Bed No,string,yes' value="<%=currentBedNo%>" />
</span>
<div class="clear"></div>
<div id="motherTransferDiv" style="display: none;">
<label> To Doctor <span>*</span></label> 
<div id ="doctorList">
<select name="mother<%=TO_DOCTOR %>"	id="motherdoctorId">
	<option value="0">Select</option>
</select> 
</div>
 <label> Transfer reason <span>*</span></label>
 <textarea  id="transferReason" name="transferReason" validate='Reason,string,no' value="" maxlength="5000"></textarea>
</div>

<!-- mother procedure -->

<div class="clear"></div>
<div id="motherProcdure" style="display: none">
<div class="paddingTop40"></div>
<div class="Clear"></div>
 <div class="floatLeft" style="width: 300px;">
				<input type="button" class="button" value="Delete"
					onclick="removeSurgicalRow('0');" /> <input type="button"
					class="button" onclick="addMotherSurgicalRequRow();" value="Add"/>
			</div>
			<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="motherSurgicalGrid">
	<tr>
		<!-- <th scope="col" style="width: 20px;">S.No</th> -->
		<th scope="col">Procedure <span>*</span></th>
		<th scope="col">Select</th>
	</tr>
	<%int i=1;
	String pName="";
	String admisDate="",UHID="",patName="",adNo="",deptName="",inpatientId="";

		//i++;
	%>
	<tr>
		  		<td><input type="text" class="opdTextBoxSmall textYellow" name="procedure<%=i%>" id="procedure<%=i%>" 
		  		onblur="checkMotherMappedChargeIP(this.value,'<%=i%>');getMotherProcedureId(this.value,'<%=i %>');" />

		 <div id="ac2update2<%=i%>"  class="autocomplete"> <!-- style="display: none;" -->
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('procedure<%=i%>','ac2update2<%=i%>','ipd?method=checkMappedCharge',{minChars:1,
					  callback: function(element, entry) {
				            return entry + '&chargeName=' + document.getElementById('procedure<%=i%>').value;
				        },parameters:'procedure<%=i%>'});
				</script>

		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>" value="" />
		</td>
		<td><input type="checkbox" class="smalll" value="1" name="surgeryradio<%=i%>" id="surgeryradio<%=i%>" />
		<input type="hidden" name="<%=INPATIENT_ID %><%=i %>" value="1" validate="inpatientId,int,no" />
		<input type="hidden" name="<%=HIN_ID %><%=i %>" value="1" validate="hinId,int,no"/>
		</td>
	</tr>
	
	
</table>
<input type="hidden" name="motherProcCount" value="<%=i%>" id="motherProcCount"/>

</div>
<div class="paddingTop40"></div>

<%
j =0;
for(BabyDetails baby: babyList ) 
 { j++;
    	if(baby.getInpatient()==null && (!baby.getLiveStillBorn().equalsIgnoreCase("live") || !baby.getLiveStillBorn().equalsIgnoreCase("Live cyanosed") ))
    {
 %><label>Transfer Baby <%=j %> <span>*</span></label>
	<input type="hidden" name="baby<%=j%>hinId" value="<%=baby.getBabyHin().getId()%>"/>
	<input type="hidden" name="baby<%=j%>Id" value="<%=baby.getId()%>"/>
	<select name="babydead" validate='Baby <%=j %> Transfer,string,yes'>
  <option value="0">Select</option>
  <option selected>Transfer to Mortuary</option>
</select>
	
    <%}
    else
    {
    	int babyCurrentBedId = baby.getInpatient().getBed().getId();
    	String babyCurrentBedNo = baby.getInpatient().getBed().getBedNo();
    %>  
    
<label>Transfer Baby <%=j %> <span>*</span></label>
	<input type="hidden" name="baby<%=j%>InpatientId" value="<%=baby.getInpatient().getId()%>" />
	<input type="hidden" name="baby<%=j%>hinId" value="<%=baby.getBabyHin().getId()%>"/>
	<input type="hidden" name="baby<%=j%>Id" value="<%=baby.getId()%>"/>
<%-- <select name="babyTransfer<%=j%>"  validate="Baby <%=j %> Transfer,string,yes"> --%>
<select name="baby<%=j%>toWard" validate='Baby <%=j %> Transfer,string,yes' onchange="submitProtoAjaxWithDivName('transferByHin','/hms/hms/appointment?method=getDoctorList&doctorIdName=baby<%=j%>','baby<%=j%>doctorList');checkBedForWard(this.value, <%=DeliveryDetails.getInpatient().getDepartment().getId()%>, <%=otDepartmentId%>, 'baby<%=j%>TransferDiv','baby<%=j%>bedNo','baby<%=j%>bedId','<%=babyCurrentBedNo%>','<%=babyCurrentBedId%>','baby<%=j%>BedDiv', 'baby<%=j%>toWard','baby<%=j%>doctorList', 'baby<%=j%>Procdure');" id="baby<%=j%>toWard">
<option value="0">Select</option>
<%for(MasDepartment department : departmentList){ 
     if(baby.getInpatient().getDepartment().getId()==department.getId())
     {
%>
          <option value="<%=department.getId()%>" selected>Back To ward</option>
       <%}else{ %>   
<option value="<%=department.getId()%>"><%=department.getDepartmentName()%></option>

<%}} %>
</select>

<input type="hidden" name="baby<%=j%>bedId" value="" id="baby<%=j%>bedId" value="<%=babyCurrentBedId%>">


<span id="baby<%=j%>BedDiv">
<label> To Bed No. <span>*</span></label> 
<input type="text" id="baby<%=j%>bedNo"   validate='baby<%=j%> Bed No,string,yes'  readonly="readonly" value="<%=babyCurrentBedNo %>" />
</span>
<div class="clear"></div>
<div id="baby<%=j%>TransferDiv" style="display: none;" >
<label> To Doctor <span>*</span></label> 
<div id ="baby<%=j%>doctorList">
<select name="baby<%=j%><%=TO_DOCTOR %>"	id="baby<%=j%>doctorId"	>
	<option value="0">Select</option>
</select> 
</div>

 <label> Transfer reason <span>*</span></label>
 <textarea  id="babyTransferReason<%=j%>" name="babyTransferReason<%=j%>" validate='Reason,string,no' value="" maxlength="5000"></textarea>
</div>

<div class="clear"></div>

<div id="baby<%=j%>Procdure" style="display: none">
<div class="paddingTop40"></div>
<div class="Clear"></div>
 <div class="floatLeft" style="width: 300px;">
				<input type="button" class="button" value="Delete"
					onclick="removeSurgicalRow(<%=j%>);" /> <input type="button"
					class="button" onclick="addBabySurgicalRequRow(<%=j%>);" value="Add" />
			</div>
			<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="baby<%=j%>surgicalGrid">
	<tr>
		<!-- <th scope="col" style="width: 20px;">S.No</th> -->
		<th scope="col">Procedure <span>*</span></th>
		<th scope="col">Select</th>

	</tr>
	<%i=1;
	/* String pName="";
	String admisDate="",UHID="",patName="",adNo="",deptName="",inpatientId="";
 */
		//i++;
	%>
	<tr>
		  		<td><input type="text" class="opdTextBoxSmall textYellow" name="baby<%=j%>procedure<%=i%>" id="baby<%=j%>procedure<%=i%>" 
		  		onblur="checkBabyMappedChargeIP(this.value,'<%=j%>','<%=i%>');getBabyProcedureId(this.value,'<%=j%>','<%=i %>');" />

		 <div id="baby<%=j%>ac2update2<%=i%>"  class="autocomplete"> <!-- style="display: none;" -->
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('baby<%=j%>procedure<%=i%>','baby<%=j%>ac2update2<%=i%>','ipd?method=checkMappedCharge',{minChars:1,
					  callback: function(element, entry) {
				            return entry + '&chargeName=' + document.getElementById('baby<%=j%>procedure<%=i%>').value;
				        },parameters:'baby<%=j%>procedure<%=i%>'});
				</script>

<%-- 		 <div id="ac2update2<%=i%>"  class="autocomplete"> <!-- style="display: none;" -->
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('procedure<%=i%>','ac2update2<%=i%>','ipd?method=checkMappedCharge',{minChars:1,
					  callback: function(element, entry) {
				            return entry + '&chargeName=' + document.getElementById('procedure<%=i%>').value;
				        },parameters:'procedure<%=i%>'});
				</script>
 --%>



		<input type="hidden" name="baby<%=j%>procedureId<%=i %>" id="baby<%=j%>procedureId<%=i %>" value="" />
		</td>
		<td><input type="checkbox" class="smalll" value="1" name="surgeryradio<%=i%>" id="surgeryradio<%=i%>"/>
		<input type="hidden" name="<%=INPATIENT_ID %><%=i %>" value="1" validate="inpatientId,int,no" />
		<input type="hidden" name="<%=HIN_ID %><%=i %>" value="1" validate="hinId,int,no"/>
		</td>
	</tr>
	
	
</table>
<input type="hidden" name="baby<%=j%>procCount" value="<%=i%>" id="baby<%=j%>procCount"/>

</div>
<!-- added by govind 14-10-2016 -->
<%-- <input type="hidden" id="admisDate" value="<%=admisDate%>"/>
<input type="hidden"  id="UHID" value="<%=UHID%>"/>
<input type="hidden"  id="patName" value="<%=patName%>"/>
<input type="hidden"  id="IPNo" value="<%=adNo%>"/>
<input type="hidden"  id="deptName" value="<%=deptName%>"/>
<input type="hidden"  id="<%=HIN_ID %>" value="" validate="hinId,int,no"/>
<input type="hidden"  id="<%=INPATIENT_ID %>" value="<%=inpatientId%>" validate="inpatientId,int,no" />  --%>
<%} }
%>
<input type="hidden"  id="babyCount" name ="babyCount" value="<%=j%>" />



<div class="Clear"></div>
<input name="" type="button" class="button" value="Transfer"
	onclick="if(validateLrTransfer()){submitForm('transferByHin','lr?method=submitLrPatientTransfer');}"/> 
</div>


<div class="Clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=currentDate%></label> <label>Changed Time:</label> <label
	class="value"><%=currentTime%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CURRENT_TIME%>" value="<%=currentTime%>" /></div>
<%-- 	<input type="hidden" name="rights" id="rights" value="<%=right%>"> --%>
	<input type="hidden" name="<%=CURRENT_DATE%>" id="currentDate" value="<%=currentDate%>"/>
<div class="Clear"></div>



</form>
<%}
else{
%>
	<h4>No Records Found</h4>
	
<%}
%>

<div class="Clear"></div>

<script type="text/javascript">
function checkBabyMappedChargeIP(val, babyNo, count) {
	
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	
	var id = val.substring(index1, index2);
	if (id == "") {
		console.log("chage "+'baby'+babyNo+'procedure' + count);
			document.getElementById('baby'+babyNo+'procedure' + count).value = "";
			
		
	}
	
		if (val != "") {				
					
					document.getElementById('baby'+babyNo+"procedureId" + count).value = id;
								for (var xx = 1; xx <count; xx++) {
								/*  if(document.getElementById("pacstatus" + xx)!=null && document.getElementById("pacstatus" + xx).value =='Pending')
									 { */
									if (document.getElementById('baby'+babyNo+"procedureId" + count)!=null && document.getElementById('baby'+babyNo+"procedureId" + xx)!=null && document.getElementById('baby'+babyNo+"procedureId" + count).value == document.getElementById('baby'+babyNo+"procedureId" + xx).value)
									{
										document.getElementById('baby'+babyNo+"procedureId" + count).value = "";
										document.getElementById('baby'+babyNo+"procedure" + count).value = "";
										alert("charge already taken");
										break;
									}
								//}
								}
							
} 
		
}

function checkMotherMappedChargeIP(val,count) {

	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	
	var id = val.substring(index1, index2);
	if (id == "") {
		
			document.getElementById('procedure' + count).value = "";
	}
	
		if (val != "") {				
					
					document.getElementById("procedureId" + count).value = id;
								for (var xx = 1; xx <count; xx++) {
								/*  if(document.getElementById("pacstatus" + xx)!=null && document.getElementById("pacstatus" + xx).value =='Pending')
									 { */
									if (document.getElementById('procedureId' + count)!=null &&document.getElementById('procedureId' + xx)!=null && document.getElementById('procedureId' + count).value == document.getElementById('procedureId' + xx).value)
									{
										document.getElementById('procedureId' + count).value = "";
										document.getElementById('procedure' + count).value = "";
										alert("charge already taken");
										break;
									}
								//}
								}
							
} 
		
}
function getBabyProcedureId(val,babyNo,inc){
	if(val!=''){
		var index1 = val.indexOf("[");
		var index2 = val.indexOf("]");
		index1++;
		var procName = val.substring(0,index1-1);
		var procId = val.substring(index1,index2);
		
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var procCode = val.substring(index1,index2);
		document.getElementById('baby'+babyNo+'procedure'+inc).value=procName;
		document.getElementById('baby'+babyNo+'procedureId'+inc).value = procId;
		//document.getElementById('procedurecode'+inc).value = procCode;
	}else{
		if(document.getElementById('baby'+babyNo+'procedure'+inc)){
	      	document.getElementById('baby'+babyNo+'procedure'+inc).value="";
	      	document.getElementById('baby'+babyNo+'procedureId'+inc).value="";
	    	//document.getElementById('proDtId'+inc).value="";
	      //	document.getElementById('procRemarks'+inc).value="";
	      	//document.getElementById('procedurecode'+inc).value="";
			}
	}
	
}

function getMotherProcedureId(val,inc){
	if(val!=''){
		var index1 = val.indexOf("[");
		var index2 = val.indexOf("]");
		index1++;
		var procName = val.substring(0,index1-1);
		var procId = val.substring(index1,index2);
		
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		var procCode = val.substring(index1,index2);
		document.getElementById('procedure'+inc).value=procName;
		document.getElementById('procedureId'+inc).value = procId;
		//document.getElementById('procedurecode'+inc).value = procCode;
	}else{
		if(document.getElementById('procedure'+inc)){
	      	document.getElementById('procedure'+inc).value="";
	      	document.getElementById('procedureId'+inc).value="";
	    	//document.getElementById('proDtId'+inc).value="";
	      //	document.getElementById('procRemarks'+inc).value="";
	      	//document.getElementById('procedurecode'+inc).value="";
			}
	}
	
}

function addBabySurgicalRequRow(babyNo) {

	var tbl = document.getElementById('baby'+babyNo+'surgicalGrid');
	var lastRow = tbl.rows.length;

	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	console.log('baby'+babyNo+'procCount');
	var hdb = document.getElementById('baby'+babyNo+'procCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	
	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	var e2 = document.createElement('input');
	e1.type = 'text';
	e2.type = 'hidden';
	e1.name = 'baby'+babyNo+'procedure'+ iteration;
	e1.id = 'baby'+babyNo+'procedure'+ iteration;
	e1.className = "opdTextBoxSmall textYellow";

	e1.onblur = function(event) {
		checkBabyMappedChargeIP(this.value,babyNo,iteration);getBabyProcedureId(this.value,babyNo,iteration);
	};
	 var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2update2'+iteration;
	  newdiv1.className = 'autocomplete';
	  newdiv1.style.display = 'none';
	  
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(newdiv1);
	  
	  new Ajax.Autocompleter('baby'+babyNo+'procedure'+ iteration,'ac2update2'+iteration,'ipd?method=checkMappedCharge',{minChars:1,
		  callback: function(element, entry) {
	            return entry + '&chargeName=' + document.getElementById('baby'+babyNo+'procedure'+ iteration).value;
	        },parameters:'requiredField=baby'+babyNo+'procedure'+ iteration});	 
	
	e2.name = 'baby'+babyNo+'procedureId'+ iteration;
	e2.id = 'baby'+babyNo+'procedureId'+ iteration;
	
	cellRight1.appendChild(e2);
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'surgeryradio' + iteration;
	e1.id = 'surgeryradio' + iteration;
	e1.className = 'smalll';

	cellRight1.appendChild(e1);

	
}

function addMotherSurgicalRequRow() {
	var tbl = document.getElementById('motherSurgicalGrid');
	var lastRow = tbl.rows.length;

	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('motherProcCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	
	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	var e2 = document.createElement('input');
	e1.type = 'text';
	e2.type = 'hidden';
	e1.name = 'procedure'+ iteration;
	e1.id = 'procedure'+ iteration;
	e1.className = "opdTextBoxSmall textYellow";

	e1.onblur = function(event) {
		checkMotherMappedChargeIP(this.value,iteration);getMotherProcedureId(this.value,iteration);
	};
	 var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2update2'+iteration;
	  newdiv1.className = 'autocomplete';
	  newdiv1.style.display = 'none';
	  
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(newdiv1);
	  
	  new Ajax.Autocompleter('procedure'+ iteration,'ac2update2'+iteration,'ipd?method=checkMappedCharge',{minChars:1,
		  callback: function(element, entry) {
	            return entry + '&chargeName=' + document.getElementById('procedure'+ iteration).value;
	        },parameters:'requiredField=procedure'+ iteration});	 
	
	e2.name = 'procedureId'+ iteration;
	e2.id = 'procedureId'+ iteration;
	
	cellRight1.appendChild(e2);
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'surgeryradio' + iteration;
	e1.id = 'surgeryradio' + iteration;
	e1.className = 'smalll';

	cellRight1.appendChild(e1);

	
}

function jsSetBedId(bedId,bedIdFieldId)
{
	//alert("dhhf");
   //alert("s"+ document.getElementById("bedId").value);
   //alert("here");
   document.getElementById(bedIdFieldId).value=bedId;
}

function getDoctorList(doctorDiv,doctorName)
{
	
	}
/* function removeSurgicalRow(babyNo) {
	var tbl = document.getElementById(form);
	var lastRow = tbl.rows.length;
	var hdb;
	var radio = "";
	var form = 'baby'+babyNo+'surgicalGrid' 
	if (form == 'surgicalGrid') {
		hdb = document.getElementById('procCount');
		radio = "surgeryradio";
	}
} */

function removeSurgicalRow(babyNo) {
	var form;
	var hdb;
  if(babyNo==0)
	  {
	  hdb = document.getElementById('motherProcCount');
	  var form = 'motherSurgicalGrid';
	  }
  else
	  {
	  hdb = document.getElementById('baby'+babyNo+'procCount');
	  var form = 'baby'+babyNo+'surgicalGrid';
	  }
  
	var tbl = document.getElementById(form);
	var lastRow = tbl.rows.length;
	var radio = "";
	//if (form == 'surgicalGrid') {
	//	hdb = document.getElementById('baby'+babyNo+'procCount');
		radio = "surgeryradio";
	//}
	

	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById(radio + i) != null
					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
					&& document.getElementById(radio + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
			alert('Please select atleast 1 row to delete');
		}
		/*
		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
		 * not delete all Row.'); } else if (lastRow > 2){
		 */
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById(radio + i) != null
					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
					&& document.getElementById(radio + i).checked) {
				var deleteRow = document.getElementById(radio + i).parentNode.parentNode;
				document.getElementById(radio + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}

	}
}
	
	
function validateLrTransfer()
{
	
	
	
	
	var babycount = document.getElementById("babyCount").value;
	var otDepartmentId = document.getElementById("otDepartmentId").value;
     var returnResult = false;
     
     if( document.getElementById("motherdoctorId")!=null && document.getElementById("motherdoctorId").value!="0" && document.getElementById("transferReason").value=="")
 	{
 	  alert("Please enter mother transfer reason");
 	  return false;
 	}
     
     for(var i=1; i<=babycount;i++)
    	 {
    	 
    	  if( document.getElementById("baby"+i+"doctorId")!=null && document.getElementById("baby"+i+"doctorId").value!="0" && document.getElementById("babyTransferReason"+i).value=="")
    	 	{
    	 	  alert("Please enter baby "+i+" transfer reason");
    	 	  return false;
    	 	}
    	 }
     
     
     
     if(document.getElementById("motherwardId").value==otDepartmentId)
	 {
		var motherPCount = document.getElementById("motherProcCount").value;  
		for (var xx = 1; xx <=motherPCount; xx++) {
			//alert("fsff");
			//alert(document.getElementById('procedure' + xx)!=null);
			//alert(document.getElementById('procedure' + xx).value!='');
		
				if (document.getElementById('procedure' + xx)!=null && document.getElementById('procedure' + xx).value!="")
				{
					returnResult =true;
					break;
				}
			}
		
		if(!returnResult)
			{
	      alert("Please Enter surgery for Mother");
	      return false;
			}
	 }
     for(var i=1; i<=babycount;i++)
    	 {
    	 returnResult = false;
    	 
    	     if(document.getElementById("baby"+i+"toWard")!=null && document.getElementById("baby"+i+"toWard").value==otDepartmentId)
    	    	 {
    	    	
    	    	 var babyPCount = document.getElementById("baby"+i+"procCount").value;    
 	    		for (var xx = 1; xx <=babyPCount; xx++) {
 	    			
 	    			if (document.getElementById('baby'+i+'procedure' + xx)!=null && document.getElementById('baby'+i+'procedure' + xx).value!="")
							{
								
 	    				        returnResult= true;
								break
							}
						}   	    	 
    	    	 if(!returnResult)
    	    		 {
    	    	   alert("Please Enter surgery for Baby "+i);
    	    	   return false;
    	    	 }
    	    
    	 } 
    	 }
     
    
	return true;
}


	 
</script>
