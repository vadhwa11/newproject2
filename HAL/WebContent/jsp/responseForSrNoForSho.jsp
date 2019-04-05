<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>

<%

Map<String, Object> map = new HashMap<String, Object>();
String serviceNo="";
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
/*List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
if(map.get("dependentList") != null){
	dependentList = (List<MasEmployeeDependent>)map.get("dependentList");
}*/
List<Patient> dependentList = new ArrayList<Patient>();
if(map.get("dependentList") != null){
	dependentList = (List<Patient>)map.get("dependentList");
	
}
//List<Patient> DepenList = new ArrayList<Patient>();
//DepenList = (List<Patient>)map.get("DepenList");


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
if(dependentList.size()>0)
{
	
		
		patientName=dependentList.get(0).getPFirstName();
		if(dependentList.get(0).getPLastName() != null)
		{
			patientName=patientName+" "+dependentList.get(0).getPLastName();
		}
		
		patientRankName=dependentList.get(0).getRank().getRankName();
		
		age=dependentList.get(0).getAge();
		
		unitName=dependentList.get(0).getUnit().getUnitName();
		
		service=""+dependentList.get(0).getServiceYears()+""+dependentList.get(0).getTotalServicePeriod() ;
		
		int serviceNo1 = service.indexOf(".");
		 serv=service.substring(0,serviceNo1);
		 residence = dependentList.get(0).getAddress();
		// String hin_id=dependentList.get(0).getHinNo().
		 
}
%>
<%
	 
		for(Patient patient: dependentList)
		{
			int hinId=patient.getId();
			System.out.println("hinId in response Jsp=====********>>>>"+hinId);
			%>
			<input type="hidden" name="hinId" value=<%=hinId %>  />
		  <%} %>
<div id="srNoDiv">
<label>Service No. </label>
<input type="text" name="<%=SERVICE_NO %>"  validate="Service No,alphanumeric,yes"  id="serviceNoId" value="<%=serviceNo %>"
    onblur="getPatientDetails(this.value);"  />

<label>Name</label>
<input type="text" name="patientName" id="nameId"  validate="name, string,no" value="<%=patientName%>" />

<label>Rank</label>
<input type="text" name="rank"  validate="rank, number,no" id="rank/RateId" value="<%=patientRankName%>" />
<div class="clear"></div>
<label>Age</label>
<input type="text" name="age" validate="age , number,no" id="ageId" value="<%=age%>" />

<label>Service</label>
<input type="text" name="lenghtofService" validate="length of service , string,no" id="lenghtofServiceId" value="<%=serv%>" />

<label>Unit/Ship</label>
<input type="text" name="unit/Ship" validate="unit , string,no" id="unit/ShipId" value="<%=unitName%>" />
<div class="clear"></div> 
<label>Residence</label> 
<input type="text" name="residence" validate="unit , string,no" id="residence" value="<%=residence %>" />

</div>

