<%-- <%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%> --%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
	
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

	

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/opd.js"></script>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>
<script src="/hms/jsp/js/ipd.js"></script>
	<!-- by govind end-->
<script type="text/javascript">
function checkSubmitSurgery() {
	 var chargeCode=document.getElementById('chargeCodeName1').value
	var index1 = chargeCode.lastIndexOf("[");
   var index2 = chargeCode.lastIndexOf("]");
   index1++;
   var id = chargeCode.substring(index1,index2);
   if(id ==""){
   	alert("Please Enter The Surgery For the patient.")
		return false ;
	}
	return true;
}	

	// by govind 
	var callbck_index =function(ret_OUT){setValue(ret_OUT);};
	var semantictag_IN;
	var acceptability_IN;
	var state_IN ;
	var returnlimit_IN;
	var retterm_value ={};
	//by govind end
</script>

<script type="text/javascript" language="javascript">
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
		serverdate = '<%=date+"/"+month+"/"+year%>';
</script>

<%
/* URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in); */

		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		
		String message = "";
		
		if(map.get("message") != null){
			message = (String)map.get("message");
		}

		int hospitalId=0;
		int orderNo=0;
		String userName = "";
		String empName="";
		String patientName="";
		String servicePersonName="";
		List<Inpatient> inpatientSurgeryList = new ArrayList<Inpatient>();
		/* List<HospitalDoctorUnitM>hospitalDoctorUnitMList=new ArrayList<HospitalDoctorUnitM>(); */

		if(map.get("inpatientSurgeryList")!=null)
		{
			inpatientSurgeryList=(List<Inpatient>)map.get("inpatientSurgeryList");
		}
		
	
		List<OpdSurgeryDetail> surgeryDetailList=new ArrayList<OpdSurgeryDetail>();
		if(map.get("surgeryDetailList")!=null)
		{
			surgeryDetailList=(List<OpdSurgeryDetail>)map.get("surgeryDetailList");
		}
		//added by govind 14-10-2016 end
		
	
	String majSur ="";

try
{
	majSur = HMSUtil.getProperties("adt.properties", "subChargeCodeForMajorSurgery");
}
catch(Exception e)
{
	e.printStackTrace();
}
%>

<div class="Clear"></div>

<h4><%=message%></h4>

<div class="titleBg">

<h2>Surgery Planning</h2>
</div>
<div class="Block">
<div class="clear"></div>
<form name="searchForsurgery" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>		
<!-- <script type="text/javascript">
   var icdArray=new Array();
</script> -->



<div class="paddingTop15"></div><div class="clear"></div>

<div class="paddingTop15"></div>



</form>
<form name="inpatientSurgeryRequisition" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
if(inpatientSurgeryList.size()>0)
{
%>
<div class="floatLeft" style="width: 300px;">
				<input type="button" class="button" value="Delete"
					onclick="removeRow('investigationGrid');" /> <input type="button"
					class="button" onclick="addSurgicalRequRow();" value="Add" />
			</div>
			<div class="clear"></div>
			<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col" style="width: 20px;">S.No</th>
		<th scope="col">Admission Date</th>
		<th scope="col">HIN No</th>
		<th scope="col">Patient Name</th>
		<th scope="col">A&D No.</th>
		<th scope="col">Department</th>
		<!-- <th scope="col">Unit</th> -->
		<th scope="col" style="width: 20px;" >Surgery Name</th>
		<!-- <th scope="col">Tentative Date</th> -->
		<th scope="col">PAC Status</th>
		<th scope="col">Surgery Status</th>
		<th scope="col">PACS</th>
		<th scope="col">Surgery Remarks</th>
				<th scope="col">Pre Anesthesia</th>
		<th scope="col">Post Anesthesia</th>
		<th scope="col">Select</th>

	</tr>
	<%int i=0;
	String pName="";
	if(surgeryDetailList.size()>0){	
		for(OpdSurgeryDetail surgDetail:surgeryDetailList)
		{
			i++;
			pName=surgDetail.getOpdSurgery().getInpatient().getHin().getPFirstName();
			if(surgDetail.getOpdSurgery().getInpatient().getHin().getPMiddleName()!=null)
			{
				pName +=" "+surgDetail.getOpdSurgery().getInpatient().getHin().getPMiddleName();
			}
			if(surgDetail.getOpdSurgery().getInpatient().getHin().getPLastName()!=null)
			{
				pName +=" "+surgDetail.getOpdSurgery().getInpatient().getHin().getPLastName();
			}
			//Set<OpdSurgeryDetail> opdDet=surgHeader.getOpdSurgeryDetails();
			%>
		<tr>
		<td><%=i%></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getDateOfAddmission() %></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getHin().getHinNo() %></td>
		<td><%=pName%></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getAdNo() %></td>
		<td><%=surgDetail.getOpdSurgery().getInpatient().getDepartment().getDepartmentName() %></td>
		<!-- <td></td>  -->
		<td><input type="text" class="opdTextBoxSmall" value="<%=surgDetail.getChargeCode().getChargeCodeName() %>[<%=surgDetail.getChargeCode().getId()%>]" readonly="readonly" id="proscedureName<%=i%>"/>
		     <input type="hidden" id="procedureId<%=i %>"	value="<%=surgDetail.getChargeCode().getId() %>" />
		</td>
	
		<td><%-- <select name="pacstatus<%=i%>" id="pacstatus<%=i%>"> --%>
		<%-- <option value="<%=surgDetail.getOpdSurgery().getPacStatus()%>" ><%=surgDetail.getOpdSurgery().getPacStatus()%></option> --%>
		<!-- </select> -->
		<%
		String pac_status="";
		if(surgDetail.getAnestheisaPacStatus()!=null)
		{
			if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("RC"))
			{
				pac_status="Requested for consultation";
			}else if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("N"))
			{
				pac_status="Pending";
			}else if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("CR"))
			{
				pac_status="Consultation received";
			}else if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("Y"))
			{
				pac_status="Cleared";
			}
			else if(surgDetail.getAnestheisaPacStatus().equalsIgnoreCase("NC"))
			{
				pac_status="Not Cleared";
			}
		}
		
			
		%>
		<%=pac_status%>
		</td>
		
	
		<td>
			<%
		String surgery_status="";
		if(surgDetail.getSurgeryStatus()!=null)
		{
			if(surgDetail.getSurgeryStatus().equalsIgnoreCase("n"))
			{
				surgery_status="Pending";
			}else if(surgDetail.getSurgeryStatus().equalsIgnoreCase("y"))
			{
				surgery_status="Complete";
			}else if(surgDetail.getSurgeryStatus().equalsIgnoreCase("c"))
			{
				surgery_status="Cancelled";
			}
		}
		
			
		%>
		<%=surgery_status%>
		</td>
		<td>
			<%
			
			if(pac_status!="" && !pac_status.equals("Pending")){
			
			if(majSur.equalsIgnoreCase(surgDetail.getChargeCode().getSubChargecode().getSubChargecodeCode())){ %>
		 <input class="button" alt="PAC" tabindex="4" value="Click" onclick="openWindow('/hms/hms/opd?method=viewPreAnesthesiaOPD&hinId=<%=surgDetail.getOpdSurgery().getHin().getId()%>&visitId=<%=surgDetail.getOpdSurgery().getVisit().getId() %>&chargeCode=<%=surgDetail.getChargeCode()!=null?surgDetail.getChargeCode().getId():"0"%>&backFlag=OPD')" type="button" align="left">
		 <%} }
			else
				out.println("-");
		 %>
		</td>
		<td>
		<%if(surgDetail.getOtBookingDt()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getSurgeryStatus()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getSurgeryStatus().equalsIgnoreCase("y")){
		   if(surgDetail.getOtBookingDt().getOtBookingHd().getAdditionalNotes()!=null && !surgDetail.getOtBookingDt().getOtBookingHd().getAdditionalNotes().isEmpty())
		   {
		%>
	<%-- 	<%=surgDetail.getOtBookingDt().getAdditionalNotes()!=null?surgDetail.getOtBookingDt().getOtBookingHd().getAdditionalNotes():"-"%></td> --%>
	
	<input class="button" alt="Post Operative Notes" tabindex="4" value="Click" onclick="openWindow('/hms/hms/opd?method=viewOtPostOperative&remarks=<%=surgDetail.getOtBookingDt().getOtBookingHd().getAdditionalNotes()%>')" type="button" align="left">
	<%} 
			else{
				out.println("N/A");
			}
				  
		}
	else
		out.println("-");
	%>
	
	
	<td>
		<%if(surgDetail.getOtBookingDt()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getOtPreAnesthesiaStatus()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getOtPreAnesthesiaStatus().equalsIgnoreCase("y")){%>
	<input class="button" alt="Pre Operative Notes" tabindex="4" value="Click" onclick="openWindow('/hms/hms/ot?method=viewPreAnesthesiaDeials&visitId=<%=surgDetail.getOpdSurgery().getVisit().getId()%>&bookingId=<%=surgDetail.getOtBookingDt().getOtBookingHd().getId()%>&inpatientId=<%=surgDetail.getOpdSurgery().getInpatient()!=null?surgDetail.getOpdSurgery().getInpatient().getId():"0"%>')" type="button" align="left">
		<%}%></td>
	
	<td>
		<%if(surgDetail.getOtBookingDt()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getOtPostAnethesiaStatus()!=null && surgDetail.getOtBookingDt().getOtBookingHd().getOtPostAnethesiaStatus().equalsIgnoreCase("y")){%>
	<input class="button" alt="Post Operative Notes" tabindex="4" value="Click" onclick="openWindow('/hms/hms/ot?method=viewPostAnesthesiaDeials&visitId=<%=surgDetail.getOpdSurgery().getVisit().getId()%>&bookingId=<%=surgDetail.getOtBookingDt().getOtBookingHd().getId()%>&inpatientId=<%=surgDetail.getOpdSurgery().getInpatient()!=null?surgDetail.getOpdSurgery().getInpatient().getId():"0"%>')" type="button" align="left">
		<%}%></td>
		<td>
		</td>
	</tr>
	
		
	<%
		}
	}
	%>
	
	<%
	
	String admisDate="",UHID="",patName="",adNo="",deptName="",inpatientId="",hinId="";
	for(Inpatient inpatient:inpatientSurgeryList)
	{ 
		i++;
	pName=inpatient.getHin().getPFirstName();
	if(inpatient.getHin().getPMiddleName()!=null)
	{
		pName +=" "+inpatient.getHin().getPMiddleName();
	}
	if(inpatient.getHin().getPLastName()!=null)
	{
		pName +=" "+inpatient.getHin().getPLastName();
	}
	//added by govind
	admisDate=inpatient.getDateOfAddmission().toString();
	UHID=inpatient.getHin().getHinNo();
	patName=pName;
	adNo=inpatient.getAdNo();
	deptName=inpatient.getDepartment().getDepartmentName();
	inpatientId=inpatient.getId().toString();
	hinId=inpatient.getHin().getId().toString();
	//added by govind
	%>

	<tr>
		<td><%=i%></td>
		<td><%=inpatient.getDateOfAddmission() %></td>
		<td><%=inpatient.getHin().getHinNo() %></td>
		<td><%=pName %></td>
		<td><%=inpatient.getAdNo() %></td>
		<td><%=inpatient.getDepartment().getDepartmentName() %></td>
		
		  
		  		<td><input type="text" class="opdTextBoxSmall textYellow" name="proscedureName<%=i%>" id="proscedureName<%=i%>" 
		  		onblur="checkMappedChargeIP(this.value,'<%=i%>');"
		 />
		 
		 
		
		 <div id="ac2update2<%=i%>" style="display: none;" class="autocomplete">
		</div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('proscedureName<%=i%>','ac2update2<%=i%>','ipd?method=checkMappedCharge',{minChars:1,
					  callback: function(element, entry) {
				            return entry + '&chargeName=' + document.getElementById('proscedureName<%=i%>').value;
				        },parameters:'requiredField=proscedureName<%=i %>'});
				</script>
		

		<input type="hidden" name="procedureId<%=i %>" id="procedureId<%=i %>"	value="" />
		 
		
		</td>
		
		<td><input type="hidden" name="pacstatus<%=i%>" id="pacstatus<%=i%>" value="n"/>Pending
		<!-- <option value="0">select</option> -->
		<!-- <option value="Pending">Pending</option> -->
		<!-- <option value="Cleared">Clear</option>
		<option value="Not Fit">Not Fit</option> -->
		<!-- </select> -->
		</td>
		<td><input type="hidden" name="surgeryStatus<%=i%>" id="surgeryStatus<%=i%>" value="n"/>Pending
		
		</td>
		<td>-</td>
		<td>-</td>
		<td>-</td>
		<td>-</td>
		<td><input type="checkbox" class="smalll" value="1" name="surgeryradio<%=i%>" id="surgeryradio<%=i%>" />
		<%-- <input type="hidden" name="<%=INPATIENT_ID %><%=i %>" value="<%=inpatient.getId() %>" validate="inpatientId,int,no" />
		<input type="hidden" name="<%=HIN_ID %><%=i %>" value="<%=inpatient.getHin().getId() %>" validate="hinId,int,no"/> --%>
		</td>
	</tr>
	
	<%} %>
</table>
</div>
<input type="hidden" name="procCount" value="<%=i %>" id="procCount" />
<!-- added by govind 14-10-2016 -->
<input type="hidden" id="admisDate" value="<%=admisDate%>"/>
<input type="hidden"  id="UHID" value="<%=UHID%>"/>
<input type="hidden"  id="patName" value="<%=patName%>"/>
<input type="hidden"  id="IPNo" value="<%=adNo%>"/>
<input type="hidden"  id="deptName" value="<%=deptName%>"/>
<input type="hidden"  id="<%=INPATIENT_ID %>" name= "inpatientId" value="<%=inpatientId%>" validate="inpatientId,int,no" />
<input type="hidden"  id="<%=HIN_ID %>" name= "hinId" value="<%=hinId%>" validate="hinId,int,no"/>
<!-- added by govind 14-10-2016 end -->
<div class="clear"></div>
<div class="paddingTop40"></div>
<input name="Submit" type="button" align="right" class="button" value="Save"
	onclick="submitSurgryRequisition();" />
	<input type="reset" class="button" name="reset" value="reset" onclick="submitForm('inpatientSurgeryRequisition','ipd?method=showSurgeryRequisitionJspFromPatientList');"/>

<input type="button" class="button" name="reset" value="Back" onclick="submitForm('inpatientSurgeryRequisition','ipd?method=showPatientListJsp');"/>
<%} else{%>
<h4> No Patient Record Exist</h4>
<% 
}
%>



<div class="clear"></div>
<div class="paddingTop40"></div>
</form>
</div>
<div class="paddingTop40"></div>

<script type="text/javascript">
function getProcedureId(val,inc){
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
		document.getElementById('proscedureName'+inc).value=procName;
		document.getElementById('procedureId'+inc).value = procId;
		//document.getElementById('procedurecode'+inc).value = procCode;
		
		
	}else{
		if(document.getElementById('proscedureName'+inc)){
	      	document.getElementById('proscedureName'+inc).value="";
	      	document.getElementById('procedureId'+inc).value="";
	    	//document.getElementById('proDtId'+inc).value="";
	      //	document.getElementById('procRemarks'+inc).value="";
	      	//document.getElementById('procedurecode'+inc).value="";
			}
	}
	
}

function submitSurgryRequisition()
 {
	var countSurgery=document.getElementById("procCount").value;
	var adNo=document.getElementById("IPNo").value;
	var selectedCount=0;
	for(var i=1;i<=countSurgery;i++)
		{
		if(document.getElementById("surgeryradio"+i)!=null){
		if(document.getElementById("surgeryradio"+i).checked)
			{
			selectedCount++;
			 document.getElementById("proscedureName"+i).setAttribute("validate", "Proscedure,metachar,yes");
			 document.getElementById("procedureId"+i).setAttribute("validate", "Proscedure,int,yes");
			// document.getElementById("tentativeDate"+i).setAttribute("validate", "Tentative Date,date,yes");
			 document.getElementById("pacstatus"+i).setAttribute("validate", "Pac Status,metachar,yes");
			}
		else
			{
			document.getElementById("proscedureName"+i).setAttribute("validate", "Proscedure,metachar,no");
			 document.getElementById("procedureId"+i).setAttribute("validate", "Proscedure,int,no");
			// document.getElementById("tentativeDate"+i).setAttribute("validate", "Tentative Date,date,no");
			 document.getElementById("pacstatus"+i).setAttribute("validate", "Pac Status,metachar,no");
			}
		}
		}
	if(selectedCount==0)
		{
		//alert("Please select at least one patient to submit"); //changed by govind
		alert("Please select at least one row to submit");
		return;
		}
	
	submitForm('inpatientSurgeryRequisition','ipd?method=submitSurgeryRequisitionDetailsForInpatient&parent='+document.getElementById("inpatientId").value);
	
	}
	

function addSurgicalRequRow() {

	var tbl = document.getElementById('investigationGrid');
	//var hdbTabIndex = parseInt(document.getElementById('usghdbTabIndex').value) + 1;
	//document.getElementById('usghdbTabIndex').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('procCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	cellRight1.innerHTML=iteration;

	var cellRight1 = row.insertCell(1);
	cellRight1.innerHTML=document.getElementById('admisDate').value;
	
	var cellRight1 = row.insertCell(2);
	cellRight1.innerHTML=document.getElementById('UHID').value;
	
	var cellRight1 = row.insertCell(3);
	cellRight1.innerHTML=document.getElementById('patName').value;
	
	var cellRight1 = row.insertCell(4);
	cellRight1.innerHTML=document.getElementById('IPNo').value;	
	
	var cellRight1 = row.insertCell(5);
	cellRight1.innerHTML=document.getElementById('deptName').value;	
	
	/* var cellRight1 = row.insertCell(6);
	cellRight1.innerHTML=""; */
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	var e2 = document.createElement('input');
	e1.type = 'text';
	e2.type = 'hidden';
	e1.name = 'proscedureName' + iteration;
	e1.id = 'proscedureName' + iteration;
	e1.className = "opdTextBoxSmall textYellow";
	
	/* e1.onkeypress = function(event) {
		selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'proscedureName'+iteration);
	}; */
	e1.onblur = function(event) {
		checkMappedChargeIP(this.value,iteration);
	};
	 var newdiv1 = document.createElement('div');
	  newdiv1.id='ac2update2'+iteration;
	  newdiv1.className = 'autocomplete';
	  newdiv1.style.display = 'none';
	  
	  cellRight1.appendChild(e1);
		cellRight1.appendChild(newdiv1);
	  
	  new Ajax.Autocompleter('proscedureName'+iteration,'ac2update2'+iteration,'ipd?method=checkMappedCharge',{minChars:1,
		  callback: function(element, entry) {
	            return entry + '&chargeName=' + document.getElementById('proscedureName'+iteration).value;
	        },parameters:'requiredField=proscedureName'+iteration});	 

	
	e2.name = 'procedureId' + iteration;
	e2.id = 'procedureId' + iteration;
	
	
	cellRight1.appendChild(e2);
	
	var cellRight1 = row.insertCell(7);
	/* var e1 = document.createElement('select'); */
	/* e1.options[0] = new Option('Select', '0'); */
	/* e1.options[0] = new Option('Pending', 'Pending'); */
	/* e1.options[2] = new Option('Clear', 'Cleared');
	e1.options[3] = new Option('Not Fit', 'Not Fit'); */
	/* e1.name = 'pacstatus' + iteration;
	e1.id = 'pacstatus' + iteration;
	cellRight1.appendChild(e1); */
	
	var e3 = document.createElement('input');
	e3.type = 'hidden';
	e3.name = 'pacstatus' + iteration;
	e3.id = 'pacstatus' + iteration;
	e3.value ='n';
	cellRight1.appendChild(e3);
	cellRight1.innerHTML = cellRight1.innerHTML + "Pending";
	
	var cellRight1 = row.insertCell(8);
	var e4 = document.createElement('input');
	e4.type = 'hidden';
	e4.name = 'surgeryStatus' + iteration;
	e4.id = 'surgeryStatus' + iteration;
	e4.value ='n';
	cellRight1.appendChild(e4);
	cellRight1.innerHTML = cellRight1.innerHTML + "Pending";
	
	var cellRight1 = row.insertCell(9);
	var e4 = document.createElement('input');
	e4.type = 'hidden';
	e4.name = 'surgeryStatus' + iteration;
	e4.id = 'surgeryStatus' + iteration;
	e4.value ='n';
	cellRight1.appendChild(e4);
	cellRight1.innerHTML = cellRight1.innerHTML + "-";
	
	var cellRight1 = row.insertCell(10);
	var e4 = document.createElement('input');
	e4.type = 'hidden';
	e4.name = 'surgeryStatus' + iteration;
	e4.id = 'surgeryStatus' + iteration;
	e4.value ='n';
	cellRight1.appendChild(e4);
	cellRight1.innerHTML = cellRight1.innerHTML + "-";
	
	var cellRight1 = row.insertCell(11);
	var e4 = document.createElement('input');
	e4.type = 'hidden';
	e4.name = 'surgeryStatus' + iteration;
	e4.id = 'surgeryStatus' + iteration;
	e4.value ='n';
	cellRight1.appendChild(e4);
	cellRight1.innerHTML = cellRight1.innerHTML + "-";
	
	var cellRight1 = row.insertCell(12);
	var e4 = document.createElement('input');
	e4.type = 'hidden';
	e4.name = 'surgeryStatus' + iteration;
	e4.id = 'surgeryStatus' + iteration;
	e4.value ='n';
	cellRight1.appendChild(e4);
	cellRight1.innerHTML = cellRight1.innerHTML + "-";
	
	var cellRight1 = row.insertCell(13);
	var e5 = document.createElement('input');
	e5.type = 'checkbox';
	e5.name = 'surgeryradio' + iteration;
	e5.id = 'surgeryradio' + iteration;
	e5.className = 'smalll';
	cellRight1.appendChild(e5);
	
	
	 var e6 = document.createElement('input');
	e6.type = 'hidden';
	e6.name = 'inpatientId' + iteration;
	e6.id = 'inpatientId' + iteration;
	e6.value=document.getElementById('inpatientId').value; 
	
	 var e7 = document.createElement('input');
	e7.type = 'hidden';
	e7.name = 'hinId' + iteration;
	e7.id = 'hinId' + iteration;
	e7.value=document.getElementById('hinId').value; 
	cellRight1.appendChild(e6);
	cellRight1.appendChild(e7);
	
	
}


function removeRow(form) {
	var tbl = document.getElementById(form);
	var lastRow = tbl.rows.length;
	var hdb;
	var radio = "";
	if (form == 'investigationGrid') {
		hdb = document.getElementById('procCount');
		radio = "surgeryradio";
	}
	

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
	
function checkMappedChargeIP(val, count) {
	
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var id = val.substring(index1, index2);
	if (id == "") {
		
			document.getElementById('proscedureName' + count).value = "";
			
		
	}
	
		if (val != "") {				
					
					document.getElementById("procedureId" + count).value = id;
								for (var xx = 1; xx <count; xx++) {									
								
								 if(document.getElementById("pacstatus" + xx)!=null && document.getElementById("pacstatus" + xx).value =='Pending')
									 {
									if (document.getElementById("procedureId" + count).value == document.getElementById("procedureId" + xx).value)
									{
									
										document.getElementById("procedureId" + count).value = "";
										document.getElementById("proscedureName" + count).value = "";
										alert("charge already taken");
										break;
									}
								}
								}
							
} 
}
		
	/* 	function checkMappedChargeIP(val, count) {
			jQuery(function($) {
				if (val != "") {
					$
							.ajax({
								url : "/hms/hms/ipd?method=checkMappedCharge",
								data : {
									chargeName : val
								},
								success : function(result) {
									var str = result.split("|");
									if (str[0] == "success") {
										$("#procedureId" + count).val(str[1]);
										for (var xx = 0; xx <= count - 1; xx++) {
											if ($("#procedureId" + count).val() == $(
													"#procedureId" + xx).val()) {
												$("#procedureId" + count).val("");
												$("#proscedureName" + count)
														.val("");
												alert("charge already taken");
												break;
											}
										}
									} else if (str[0] == "failed") {
										alert(val.toUpperCase()
												+ " charge is not configured. please configured before prescribe.");
										$("#proscedureName" + count).val("");
										$("#procedureId" + count).val("");
									}
								}
							});
				}
			});
		} */
/* function checkMappedChargeIP(strValue, inc) {

	var index1 = strValue.lastIndexOf("[");
	var index2 = strValue.lastIndexOf("]");
	index1++;
	var id = strValue.substring(index1, index2);

	if (id == "") {
		
			document.getElementById('proscedureName' + inc).value = "";
			
		
	}
	
} */


function selectSNOMEDCT(state_IN, semantictag_IN, acceptability_IN,
		returnlimit_IN, callback, from, iteration) {
	jQuery(function($) {
		if (returnlimit_IN <= -1 || returnlimit_IN == ''
				|| returnlimit_IN == undefined || returnlimit_IN == null) {
			returnlimit_IN = -1;

		}
		returnlimitParam = returnlimit_IN;

		if (state_IN == -1 || state_IN == null || state_IN == ''
				|| state_IN == undefined) {
			state_IN = enumSTATE.BOTH;
		} else

			state_IN = enumSTATE[state_IN];

		stateParam = state_IN;

		if (semantictag_IN == -1 || semantictag_IN == null
				|| semantictag_IN == undefined || semantictag_IN == '') {
			semantictag_IN = enumSEMANTICTAG.ALL;
		} else
			semantictag_IN = enumSEMANTICTAG[semantictag_IN];

		semantictagParam = semantictag_IN;

		if (acceptability_IN == -1 || acceptability_IN == null
				|| acceptability_IN == undefined || acceptability_IN == '') {
			acceptability_IN = enumACCEPTABILITY.ALL;
		} else
			acceptability_IN = enumACCEPTABILITY[acceptability_IN];

		acceptabilityParam = acceptability_IN;

		/* jQuery('.ui-dialog button:nth-child(0)').button('disable'); */
		$('.ui-dialog-buttonpane').find("button").show().filter(
				":contains('.')").hide();

		var txtBox = document.getElementById(from);
		txtBox.focus();

		var xhrRequest = null;
		$("#" + from).autocomplete(
						{
							max : 20,
							minLength : 3,
							cacheLength : 1,
							scroll : false,
							width : 520,
							highlight : false,
							autoFocus : false,
							source : function(request, response) {

								var dataValue = document.getElementById(from).value;

								var servURL = "";
								if (dataValue == '') {
									$("#dialog-form").dialog("option",
											"height", 160);
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									var txtBox = document.getElementById(from);
									txtBox.focus();
									return;
								}

								if (dataValue.length >= 3) {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									$("#msg3chars").hide();
									$('#nosuggestion').hide();

								} else {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
								}

								servURL = enumSERVICES.SEARCH.suggestbyacceptability_url;

								servURL += "?term="
										+ encodeURIComponent(request.term)
										+ "&state=" + stateParam
										+ "&semantictag=" + semantictagParam
										+ "&acceptability="
										+ acceptabilityParam + "&returnlimit=5";
								console.log(servURL);

								if (xhrRequest && xhrRequest.readystate != 4)
									xhrRequest.abort();
								xhrRequest = $
										.ajax({
											type : "GET",
											url : servURL,
											dataType : "jsonp",
											crossDomain : true,
											success : function(data,
													textStatus, jqXHR) {
												console.log(data);
												var items = data;

												response(items);
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);

											}
										});

							},
							select : function(event, ui) {
								var data = document.getElementById(from).value;
								if (data.length >= 3) {
									$("#msg3chars").hide();
									$('#nosuggestion').hide();
									document.getElementById(from).value = ui.item.value;
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									displaySearch = false;
									loadResultsList(stateParam,
											semantictagParam,
											acceptabilityParam,
											returnlimitParam, callback, from,
											iteration);
								} else {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
								}
							}

						});
	});
}

</script>

