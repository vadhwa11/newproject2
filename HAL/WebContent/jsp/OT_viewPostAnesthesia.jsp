<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/opd.js"></script>
	

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>


<!--<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
-->
<!--</script>
-->
<!--<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
-->
<!--  By Vishnu -->
<%



Map map = new HashMap();
//String includedJsp = null;
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

}

String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
int hospitalId=0;
if (session.getAttribute("hospitalId") != null) {
	hospitalId = (Integer) session.getAttribute("hospitalId");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");	 
String currentTime = (String)utilMap.get("currentTime");

List<OtPostAnaesthesiaProcedure> postAnesthesiaList = new ArrayList<OtPostAnaesthesiaProcedure>();
List<OtPostOpInstruction> otPostOpInstructionList = new ArrayList<OtPostOpInstruction>();
List<PatientPrescriptionDetails> prescriptionList = new ArrayList<PatientPrescriptionDetails>();
List<DgOrderdt> investigationList = new ArrayList<DgOrderdt>();
 List otPreOPDrugsList= new ArrayList();
if(map.get("otPostOpInstructionList") != null){
	otPostOpInstructionList=(List<OtPostOpInstruction>)map.get("otPostOpInstructionList");
}
if(map.get("postAnesthesiaList") != null){
	postAnesthesiaList=(List<OtPostAnaesthesiaProcedure>)map.get("postAnesthesiaList");
}
if(map.get("prescriptionList") != null){
	prescriptionList=(List<PatientPrescriptionDetails>)map.get("prescriptionList");
}
if(map.get("investigationList") != null){
	investigationList=(List<DgOrderdt>)map.get("investigationList");
}



 
%>
<div class="clear"></div>
<div class="clear"></div>
<h2>Post-Anesthesia Notes</h2><div class="clear"></div>
<div class="Block">
<%if(postAnesthesiaList.size()>0){ %>
			
			<h4>Post OP Instructions</h4>
			<%
			if(otPostOpInstructionList.size()>0){
				int i=0;
			%>
			<table border="0" align="center" cellpadding="0" cellspacing="0"	id="preOpInstruction">

	<tr>
		<th scope="col">SI No.</th>
		<th scope="col">Pre OP Instruction</th>
</tr>
		<%	
			
			for(OtPostOpInstruction ins:otPostOpInstructionList) {%>
			   <tr><td><%=++i%></td><td><%=ins.getPreOpInstruction()%></td></tr>
			<%}
		%>
		</table>
		<%	} else {%>
		   &nbsp;&nbsp;&nbsp;&nbsp;No record <div class="clear"></div>
	<%}%>
	
	<h4>Pre Medication</h4><div class="clear"></div>
	<% int i=0;if(prescriptionList.size()>0) {%>
	
	<div class="cmntable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
    <tr>	
        <th>S.No.</th>
        <th>Nomenclature1/Material Code</th>
		<th scope="col">Dispensing Unit</th>
		<th scope="col">Dosage<span>*</span></th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days<span>*</span></th>
		<th scope="col">Remarks</th>
		<th>Prescribed Date</th>
		</tr>
		<%for(PatientPrescriptionDetails ppd: prescriptionList){ %>
		
		  <tr><td><%=++i %></td><td><%=ppd.getItem().getNomenclature()%></td><td><%=ppd.getItem().getDispUnit()!=null?(!ppd.getItem().getDispUnit().equals("0")?ppd.getItem().getDispUnit():""):""%></td><td><%=ppd.getDosage()%>
		  </td><td><%=ppd.getFrequency().getFrequencyName()%></td><td><%=ppd.getNoOfDays()%></td><td><%=ppd.getRemarks()!=null?ppd.getRemarks():""%></td>
		  <td><%=HMSUtil.convertDateToStringWithoutTime(ppd.getPrescription().getPrescriptionDate())%></td>
		  </tr>
		
		<%} %>
</table></div>
	
	
	<%}else{
		%>
		&nbsp;&nbsp;&nbsp;&nbsp;No record <div class="clear"></div>
	<% }%>
	
	
		<h4>Investigation</h4><div class="clear"></div>
	<%if(investigationList.size()>0) {%>
	    <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
    <tr>	
        <th>S.No.</th>
        <th>Investigation</th>
        </tr>
        <%i=0; for(DgOrderdt dgDt: investigationList){ %>
           <tr><td><%=++i%></td><td><%=dgDt.getChargeCode().getChargeCodeName()%></td></tr>
		<%} %>
        </table>
	<%}else{
		%>
		&nbsp;&nbsp;&nbsp;&nbsp;No record <div class="clear"></div>
	<% }%>
    
    <div class="clear"></div><div class="clear"></div><div class="clear"></div><div class="clear"></div>
    <label>Overall assessment/GC</label><label class="value" style="width: 700px"><%=postAnesthesiaList.get(0).getOverallAssessment()!=null?postAnesthesiaList.get(0).getOverallAssessment():""%></label>
    <label>Airway</label><label class="value" style="width: 700px"><%=postAnesthesiaList.get(0).getAirway()!=null?postAnesthesiaList.get(0).getAirway():""%></label> 
    <label>Special Observation</label><label class="value" style="width: 700px"><%=postAnesthesiaList.get(0).getSpecialObservation()!=null?postAnesthesiaList.get(0).getSpecialObservation():""%></label><div class="clear"></div> 
    <label>Level of Consciousness/GCS</label><label class="value"><%=postAnesthesiaList.get(0).getGcs()!=null?postAnesthesiaList.get(0).getGcs():""%></label>
    <label>Drowsy</label><label class="value"><%=postAnesthesiaList.get(0).getDrowsy()!=null?postAnesthesiaList.get(0).getDrowsy():""%></label>
    <label>Awake</label><label class="value"><%=postAnesthesiaList.get(0).getAwake()!=null?postAnesthesiaList.get(0).getAwake():""%></label><div class="clear"></div>
    <label>Circulation</label><label class="value"><%=postAnesthesiaList.get(0).getCirculation()!=null?postAnesthesiaList.get(0).getCirculation():""%></label>
    <label>HR</label><label class="value"><%=postAnesthesiaList.get(0).getHr()!=null?postAnesthesiaList.get(0).getHr():""%></label>
    <label>BP</label><label class="value"><%=postAnesthesiaList.get(0).getBp()!=null?postAnesthesiaList.get(0).getBp():""%></label><div class="clear"></div>
    <label>CVS</label><label class="value"><%=postAnesthesiaList.get(0).getCvs()!=null?postAnesthesiaList.get(0).getCvs():""%></label>
    <label>RS</label><label class="value"><%=postAnesthesiaList.get(0).getRs()!=null?postAnesthesiaList.get(0).getRs():""%></label>
    <label>Spo2 on room Level</label><label class="value"><%=postAnesthesiaList.get(0).getSp02()!=null?postAnesthesiaList.get(0).getSp02():""%></label><div class="clear"></div>
    <label>Post additional Advice</label><textarea class="large"><%=postAnesthesiaList.get(0).getRemarks()!=null?postAnesthesiaList.get(0).getRemarks():""%></textarea>
        
<%}else{%>	
	 	<h2>No record</h2>   
	
	<%} %>

</div>

