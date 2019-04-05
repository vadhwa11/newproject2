<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex" %>
<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<%

Map<String, Object> map = new HashMap<String, Object>();
String serviceNo="";
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}

List<Patient> patientList = new ArrayList<Patient>();
if(map.get("patientList") != null){
	patientList = (List<Patient>)map.get("patientList");
	
}

if(map.get("serviceNo") != null){
	serviceNo = (String)map.get("serviceNo");
	
}

int cnt=1;

String patientName="";
String patientRelationName="";
String patientRankName="";
String name="";
String service="";
String unitName="";
String age="";
String serv="";
String residence="";
String gender = "";
String trade = "";
String servicePersonName="";
String relation = "";
if(patientList.size()>0)
{		
		patientName=patientList.get(0).getPFirstName();
		if(patientList.get(0).getPLastName() != null)
		{
			patientName=patientName+" "+patientList.get(0).getPLastName();
		}
		if(patientList.get(0).getRank().getRankName()!= null)
		{
		patientRankName=patientList.get(0).getRank().getRankName();
		}
		if(patientList.get(0).getAge()!= null)
		{		
		 age=patientList.get(0).getAge();
		}
		if(patientList.get(0).getUnit()!= null)
		{		
		 unitName=patientList.get(0).getUnit().getUnitName();
		}
		if(patientList.get(0).getServiceYears()!= null)
		{
		service=""+patientList.get(0).getServiceYears()+""+patientList.get(0).getTotalServicePeriod() ;
		}
		int serviceNo1 = service.indexOf(".");
		 serv=service.substring(0,serviceNo1);
		 if(patientList.get(0).getAddress()!= null)
		 {
		   residence = patientList.get(0).getAddress();
		 }
		// String hin_id=dependentList.get(0).getHinNo().
		
		if(patientList.get(0).getTrade()!= null)
		{
		 trade = patientList.get(0).getTrade().getTradeName() ;
		}
		if(patientList.get(0).getSex()!= null)
		{
		 gender = patientList.get(0).getSex().getAdministrativeSexName() ;
		}
		if(patientList.get(0).getRelation()!= null)
		{
			relation = patientList.get(0).getRelation().getRelationName();
		}
		
		servicePersonName=patientList.get(0).getSFirstName();
		if(patientList.get(0).getSLastName() != null)
		{
			servicePersonName = servicePersonName+" "+patientList.get(0).getSLastName();
		}
		 
}
%>
<%
for(Patient patient: patientList)
{
	int hinId=patient.getId();
%>
<input type="hidden" name="hinId" value=<%=hinId %>  id="hin_Id" />
<%} %>
		  

		  
<div id="foodHandlerDiv">

<label>Name</label>
<input type="text" name="name" id="nameId"  validate="name, string,no" value="<%=servicePersonName%>" />

<div class="clear"></div>

<label>Rank</label>
<input type="text" name="rank"  validate="rank, number,no" id="rank/RateId" value="<%=patientRankName%>" />

<label >Patient Name</label>
<input  type="text" name="patientName" validate="patientName, string,no" id="patientNameId" value="<%=patientName%>" />

<label >Relation</label>
<input  type="text" name="relation" validate="relation, string,no" id="relationid" value="<%=relation%>" />

<div class="clear"></div>

<label>Age</label>
<input type="text" name="age" validate="age , number,no" id="ageId" value="<%=age%>" />

<label>Gender</label>
<input type="text" name="gender" id="gender"   value="<%=gender%>" />

<label>Trade</label>
<input type="text"  name="trade" id="trade" value="<%=trade %>" />

<div class="clear"></div>

<label>Unit</label>
<input type="text" name="unit" validate="unit , string,no" id="unit/ShipId" value="<%=unitName%>" />


</div>


