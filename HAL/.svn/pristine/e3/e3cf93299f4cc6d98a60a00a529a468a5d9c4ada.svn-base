
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRank"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = null;
		List<MasRelation> relationList = null;
		List<MasAdministrativeSex> sexList = null;
		List<Patient> patientList = new ArrayList<Patient>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("sexList") != null){
			sexList= (List<MasAdministrativeSex>)map.get("sexList");
		}
		if(map.get("relationList") != null){
			relationList= (List<MasRelation>)map.get("relationList");
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		Patient patient = new Patient();
		if(patientList.size() > 0){
			patient = patientList.get(0);
		}
	%> 

<label> Patient Name</label> 
<%
	String pName = patient.getPFirstName();
	if(patient.getPMiddleName()!= null){
		pName += " "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!= null){
		pName += " "+patient.getPLastName();
	}
%>
<label class="value"><%= pName %></label>
<input type="hidden"	name="<%=P_FIRST_NAME %>" value="<%= pName %>" readonly="readonly" id="" />
<div class="Clear"></div>
	
<label> Relation</label> 
<label class="value"><%=patient.getRelation().getRelationName() %></label>
<input type="hidden" name="<%=RELATION_ID %>" value="<%=patient.getRelation().getId() %>"/>
 

<label>Rank</label>
<label class="value"><%=patient.getRank().getRankName() %></label>
<input type="hidden" name="<%=RANK_ID %>" value="<%=patient.getRank().getId() %>"/>

<%
	String sName = patient.getSFirstName();
	if(patient.getSMiddleName()!= null){
		sName += " "+patient.getSMiddleName();
	}
	if(patient.getSLastName()!= null){
		sName += " "+patient.getSLastName();
	}
%>
<label> Name</label> 
<label class="value"><%= sName %></label>
<input type="hidden"	name="<%=S_FIRST_NAME %>" value="<%= sName %>" readonly="readonly" id="" />
<div class="Clear"></div>
	
<label> Age</label>
<%
if(patient.getAge()!= null){
%>
<label class="value"><%= patient.getAge() %></label>
<input type="hidden"	name="patientAge" value="<%= patient.getAge() %>" readonly="readonly" id="" />
<%}else{ %>
<label class="value"></label>
<%} %>
<label> Sex</label> 
<label class="value"><%= patient.getSex().getAdministrativeSexName() %></label>
<input type="hidden"	name="<%=SEX_ID %>" value="<%= patient.getSex().getId() %>" readonly="readonly" id="" />
