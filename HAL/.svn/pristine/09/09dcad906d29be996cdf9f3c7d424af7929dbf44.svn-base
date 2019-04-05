<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%
	Map map = new HashMap();
	List<Visit> patientDetailsList = new ArrayList<Visit>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("patientDetailsList") != null)
	{
		patientDetailsList=(List)map.get("patientDetailsList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String serviceNo="";
	String patientName="";
	String patientRelationName="";
	String patientRankName="";
	String name="";
	String  unitName="";
	String age="";
	String sexName="";
	String doc_name="";
	int consultantId=0;
	int hinIdP=0;
	int visitId=0;
	int visitNumber=0;
	String hinNoS="";
	String serviceNoS="";
	

if(patientDetailsList.size()>0)
{
	
		serviceNo=patientDetailsList.get(0).getHin().getServiceNo();
		visitId=patientDetailsList.get(0).getId();
		visitNumber=Integer.parseInt(patientDetailsList.get(0).getVisitNo().toString());
		hinNoS=patientDetailsList.get(0).getHin().getHinNo().toString();
		serviceNoS=patientDetailsList.get(0).getHin().getServiceNo();
		
		
		hinIdP=patientDetailsList.get(0).getHin().getId();
		patientName=patientDetailsList.get(0).getHin().getPFirstName();
		
		if(patientDetailsList.get(0).getHin().getPLastName() != null)
		{
			patientName=patientName+" "+patientDetailsList.get(0).getHin().getPLastName();
		}
		patientRelationName	=patientDetailsList.get(0).getHin().getRelation().getRelationName();
		patientRankName=patientDetailsList.get(0).getHin().getRank().getRankName();
		name=patientDetailsList.get(0).getHin().getSFirstName();
		if(patientDetailsList.get(0).getHin().getSLastName() != null){
			name=name+" "+patientDetailsList.get(0).getHin().getSLastName();
		}
		
		//unitName=patientDetailsList.get(0).getHin().getUnit().getUnitName();
		age=patientDetailsList.get(0).getHin().getAge();
		sexName=patientDetailsList.get(0).getHin().getSex().getAdministrativeSexName();
		if(patientDetailsList.get(0).getDoctor()!=null)
		{
		doc_name=patientDetailsList.get(0).getDoctor().getFirstName();
		if(patientDetailsList.get(0).getDoctor().getLastName() != null){
			doc_name=doc_name+" "+patientDetailsList.get(0).getDoctor().getLastName();
			doc_name=patientDetailsList.get(0).getDoctor().getRank().getRankName() + " "+ doc_name;
			consultantId=patientDetailsList.get(0).getDoctor().getId();
		}}
	}

%>



<div id="patientDiv">
<%if(patientDetailsList.size()>0)
{%>
<label >Patient Name</label>
<input	type="text" id="p_name" name="patientName" value="<%=patientName %>"  tabindex="1" readonly"/>
<input type="hidden" name="hinIdP" value="<%=hinIdP%>"/> 
<input type="hidden" name="visitId" value="<%=visitId%>"/>
<input type="hidden" name="hinNoS" value="<%=hinNoS%>"/>
<input type="hidden" name="serviceNoS" value="<%=serviceNoS%>"> 
<input type="hidden" name="visitNumber" value="<%=visitNumber%>"> 
<input type="hidden" name="changeBy" id="changeBy" value="<%=userName %>"/>
 <div class="clear"></div>
<label >Relation</label>
<input type="text"	id="relation" name="relation" value="<%=patientRelationName %>"  tabindex="1" MAXLENGTH="30" validate="Relation,string,yes"	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"	onFocus="opdPatientIssue.reset();" />



<label>Designation</label>
<input type="text"	id="rank" name="rank" value="<%=patientRankName %>"  tabindex="1" MAXLENGTH="30" validate="Rank, string,yes"	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"	onFocus="opdPatientIssue.reset();" />



<label>Name</label>
<input	type="text" id="S_name" name="S_name" value="<%=name %>"  tabindex="1" readonly"/>
<div class="clear"></div>
<%-- <label >Unit</label>
<input type="text"	id="unit" name="unit" value="<%=unitName%>"  tabindex="1" MAXLENGTH="30" validate="Rank, string,yes"	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"	onFocus="opdPatientIssue.reset();" />
 --%>
<label>Age</label>
<input type="text"	id="age" name="age" value="<%=age %>"  tabindex="1" MAXLENGTH="30" validate="Age, string,yes"	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"	onFocus="opdPatientIssue.reset();" />



<label>Gender</label>
<input type="text"	id="sex" name="sex" value="<%=sexName %>"  tabindex="1" MAXLENGTH="30" validate="Gender, string,yes"	onblur="getHinNo('opdPatientIssue','stores?method=getHinForPatientIssue');submitProtoAjax('opdPatientIssue','stores?method=showOPDPatientIssueGrid');"	onFocus="opdPatientIssue.reset();" />
<label>Doctor</label>
<input	type="text" id="mo" name="mo" value="<%=doc_name %>"  tabindex="1" readonly"/>
<input	type="hidden" id="mo" name="empId" value="<%=consultantId%>"/>
<!-- <label>Specialty<span>*</span></label>
<input type="text" name="specialty" value="" id="prescribBy" validate="Specialty,string,no"/> -->
<%}else{%>
<h4><%="Visit not created for the patient.Create visit  first from Reception ."%></h4>
<%}%>
</div>
