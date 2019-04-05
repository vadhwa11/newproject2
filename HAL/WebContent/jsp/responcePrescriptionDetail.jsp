<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>

<%
	String deptName="&nbsp;";
	Date manu  = null;
	Date expiry = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String manufacturer = "";
	String url = "";

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	
	}
	
	if(session.getAttribute("deptName")!=null){
		deptName=(String)session.getAttribute("deptName");
	}
	List<PatientPrescriptionHeader> prescriptionList= new ArrayList<PatientPrescriptionHeader>();
	if (map.get("prescriptionList") != null) {
		prescriptionList = (List<PatientPrescriptionHeader>)map.get("prescriptionList");
		System.out.println("prescriptionList in jsp "+prescriptionList.size());
	}

%>
<div id="testDiv">
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<h3>Prescription Details</h3>
<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
<table >

	<thead>
		<tr>
			<th>Prescription No</th>
			<th>Date</th>
			<th>Service No.</th>
			<th>Patient Name</th>
			<!-- <th>Visit No</th> -->
			<th>Diagnosis</th>
			<th>MO</th>
			
			
		</tr>
	</thead>

	<% if(prescriptionList.size()>0){int r=0;
		for(int i=0; i<prescriptionList.size() ; i++){
			PatientPrescriptionHeader	ob=(PatientPrescriptionHeader)prescriptionList.get(i);
	%>	
	
<tr>
<td><input type="test" value="<%=ob.getPrescriptionNo()%>" readonly="readonly"/></td>
<td><input type="test" value="<%=HMSUtil.changeDateToddMMyyyy((Date)ob.getPrescriptionDate())%>" readonly="readonly"/></td>
<td><input type="test" value="<%=ob.getHin().getServiceNo()%>"  readonly="readonly"/></td>
<% String P_name="";
if(ob.getHin().getPFirstName()!= null){
	P_name=ob.getHin().getPFirstName();
}
if(ob.getHin().getSLastName()!= null)
{
	P_name +=" "+ob.getHin().getSLastName();
} %>
<td><input type="test" value="<%=P_name%>"  readonly="readonly"/></td>
<!-- <td><input type="test" value="<%=ob.getVisit().getVisitNo()%>"  readonly="readonly"/></td> -->


<% if(ob.getVisit().getDiagnosisName()!= null) {%>
<td><input type="test" value="<%=ob.getVisit().getDiagnosisName()%>"  readonly="readonly"/>
<%}else{ %>
<td><input type="test" value="<%=" "%>"  readonly="readonly"/>
<%}%>
<%
String doc=ob.getVisit().getDoctor().getFirstName();
if(ob.getVisit().getDoctor().getLastName()!=null){
	
	doc= ob.getVisit().getDoctor().getRank().getRankName()+" "+doc+"  "+ob.getVisit().getDoctor().getLastName();
}

%>
<td><input type="test" value="<%=doc%>"  readonly="readonly"/></td>

</tr>
<%}} %>
</table>
</div>