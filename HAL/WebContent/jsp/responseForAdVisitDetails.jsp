<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MlcCase"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>

<%Map<String,Object> map = new HashMap<String,Object>();
	String detailId ="";
	String parentId ="";
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
	List<Visit> visitList = new ArrayList<Visit>();
	List<Inpatient> inPatientList = new ArrayList<Inpatient>();
	
	if(map.get("visitList") != null)	{
		visitList = (List<Visit>)map.get("visitList");
	}
	if(map.get("inPatientList") != null)	{
		inPatientList = (List<Inpatient>)map.get("inPatientList");
	}
	System.out.println(" visitList in Jsp  "+visitList.size());
	System.out.println(" inpatientList in Jsp  "+inPatientList.size());
	if(inPatientList.size() >0 ){
		Inpatient inpatient=inPatientList.get(0);
	
%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.masters.business.InpatientDocument"%>
<%@page import="java.util.HashSet"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
 
<h2>Admission Deatils</h2>

<%if(inpatient.getAdStatus().equalsIgnoreCase("c")){ %>
<h2 style="color:#AC1400;align: center;">Admission Canceled</h2>
<%} %>
<div class="Clear"></div>
<label>Admission No:</label>
<label class="value"><%=inpatient.getAdNo()%></label>
<label>P Name:</label>
<label class="value"><%=inpatient.getHin().getPFirstName()+" "+inpatient.getHin().getPMiddleName()+" "+inpatient.getHin().getPLastName() %></label>
<label>Ward :</label>
<label class="value"><%=inpatient.getDepartment().getDepartmentName()%></label>

<div class="Clear"></div>

<label>Adm Date:</label>
<%if(inpatient.getDateOfAddmission() !=null){ %>
<label class="value"><%=inpatient.getDateOfAddmission()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<label>Adm Time:</label>
<%if(inpatient.getTimeOfAddmission() !=null){ %>
<label class="value"><%=inpatient.getTimeOfAddmission()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<label>Adm Type:</label>
<%if(inpatient.getAdmissionType() !=null){ %>
<label class="value"><%=inpatient.getAdmissionType().getAdmissionTypeName()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>

<label>Condition:</label>
<%if(inpatient.getAdmissionType() !=null){ %>
<label class="value"><%=inpatient.getPatientCondition()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Age:</label>
<%if(inpatient.getAge() !=null){ %>
<label class="value"><%=inpatient.getAge()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<label>Transfer from :</label>
<%if(inpatient.getTransFrom() !=null   ){
					if(!inpatient.getTransFrom().equals("")){%>
<label class="valueNoWidth"><%=inpatient.getTransFrom()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>

<label>Last AD No:</label>
<%if(inpatient.getPreviousAdNo() !=null){
				if(!inpatient.getPreviousAdNo().equals("")){
				%>
<label class="value"><%=inpatient.getPreviousAdNo()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>Adm Advised :</label>
<label class="value"><%=inpatient.getDoctor().getFirstName()+" "+inpatient.getDoctor().getMiddleName()+" "+inpatient.getDoctor().getLastName()%></label>
<label>Vip:</label>
<%
			if(inpatient.getVip() !=null){
			if(inpatient.getVip().equalsIgnoreCase("y")){ %>
<label class="value">Yes</label>
<%}else{ %>
<label class="value">No</label>
<%}}
			else{%>
<label class="value">No</label>
<%} %>

<label>H Staff:</label>
<%if(inpatient.getStaffSlNo() !=null){ %>
<label class="value">Yes</label>
<%}else{ %>
<label class="value">No</label>
<%} %>


<label>HSR Rcpt No:</label>
<%if(inpatient.getHsrReceiptNo() !=null ){
				if(!inpatient.getHsrReceiptNo().equals("")){
				%>
<label class="value"><%=inpatient.getHsrReceiptNo()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<%}else{ %>
<label class="value">-</label>
<%} %>
<label>HSR Amount:</label>
<%if(inpatient.getHsrAmount() !=null ){ %>
<label class="value"><%=inpatient.getHsrAmount()%></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<div class="Clear"></div>

<label>Return FRW :</label>
<label class="value">-</label>


<label>Diet :</label>
<label class="value"><%=inpatient.getDiet().getDietName()%></label>

<label>Doc attached :</label>
<% String docInit ="";
			Set<InpatientDocument> set=new HashSet<InpatientDocument>();
			set= (Set<InpatientDocument>)inpatient.getInpatientDocuments();
			for(InpatientDocument inpatientDocument :set){
				if(inpatientDocument.getInpatient().getId()==inpatient.getId()){
					docInit =docInit+inpatientDocument.getDocument().getDocumentName()+", ";
				}
			}
			if(docInit.equals("")){
				docInit ="-";
			}
			%>

<label class="value"><%=docInit%></label>

<div class="Clear"></div>

<label>Remarks:</label>
<%if(inpatient.getRemarks() !=null && !inpatient.getRemarks().equals("")){ %>
<label class="noHeightBig"><%=inpatient.getRemarks()%></label>
<%}else{ %>
<label class="noHeightBig">-</label>
<%} %>

<div class="Clear"></div>

<label>Diagnosis :</label>
<% String diagnosis ="";
			if(inpatient.getInitDiagnosis() !=null)
			diagnosis =inpatient.getInitDiagnosis();
			%>
<label class="noHeightBig"><%=diagnosis%></label>
<div class="Clear"></div>

<%}%>
<div class="Clear"></div>
