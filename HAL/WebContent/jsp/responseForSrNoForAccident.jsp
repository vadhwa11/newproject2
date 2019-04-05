<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<%
System.out.println("------IN Response Driver JSP------");
Map<String, Object> map = new HashMap<String, Object>();
String serviceNo="";
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
/*List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
if(map.get("dependentList") != null){
	dependentList = (List<MasEmployeeDependent>)map.get("dependentList");
}*/
List<Patient> patientList = new ArrayList<Patient>();
if(map.get("patientList") != null){
	patientList = (List<Patient>)map.get("patientList");
}

List<Patient> inpatientList = new ArrayList<Patient>();
if(map.get("inpatientList") != null){
	inpatientList = (List<Patient>)map.get("inpatientList");
}
//List<Patient> DepenList = new ArrayList<Patient>();
//DepenList = (List<Patient>)map.get("DepenList");


if(map.get("serviceNo") != null){
	serviceNo = (String)map.get("serviceNo");
	System.out.println("------serviceNo------"+serviceNo);
	
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
String maritalStatus = "";
String servicePeriod = "";
String tradeName="";
float serviceYear = 0.0f;
if(patientList.size()>0)
{
	
		
		patientName=patientList.get(0).getPFirstName();
		if(patientList.get(0).getPLastName() != null)
		{
			patientName=patientName+" "+patientList.get(0).getPLastName();
		}
		
		patientRankName=patientList.get(0).getRank().getRankName();
		
		age=patientList.get(0).getAge();
		
		unitName=patientList.get(0).getUnit().getUnitName();
		if(patientList.get(0).getServiceYears()!= null && !(patientList.get(0).getServiceYears().equals("")))
		{
		   serviceYear = patientList.get(0).getServiceYears();
		}
		if(patientList.get(0).getTotalServicePeriod() != null)
		  {
			servicePeriod = patientList.get(0).getTotalServicePeriod();
		  }
		
		//int serviceNo1 = service.indexOf(".");
		// serv=service.substring(0,serviceNo1);
		if(patientList.get(0).getAddress()!= null)
		{
		 residence = patientList.get(0).getAddress();
		}
		 if(patientList.get(0).getMaritalStatus()!= null)
		 {
		    maritalStatus = patientList.get(0).getMaritalStatus().getMaritalStatusName();
		 }
		// String hin_id=dependentList.get(0).getHinNo().
			if(patientList.get(0).getTrade()!= null)
		{
				tradeName = patientList.get(0).getTrade().getTradeName() ;
		}
}
%>
<%
	 
		for(Patient patient: patientList)
		{
			int hinId=patient.getId();
			//System.out.println("hinId in response Jsp=====********>>>>"+hinId);
			%>
			<input type="hidden" name="hinId" value=<%=hinId %>  />
		  <%} %>
<div id="DivDriver">
<!--<label>Service No. </label>
<input type="text" name="<%=SERVICE_NO %>"  validate="Service No,alphanumeric,yes"  id="serviceNoId" value="<%=serviceNo %>"
    onblur="getPatientDetails(this.value);"  />
-->

<label>Name</label>
<input type="text" name="patientName" id="nameId"  validate="name, string,no" value="<%=patientName%>" />

<label>Rank</label>
<input type="text" name="rank"  validate="rank, number,no" id="rank/RateId" value="<%=patientRankName%>" />

<label >Branch/Trade</label>
<input type="text" name="branch/Trade" validate="name , string,no" id="branch/TradeId" value="<%=tradeName%>" />
 
<label>Age</label>
<input type="text" name="age" validate="age , number,no" id="ageId" value="<%=age%>" />

<div class="clear"></div>

<label>Total Service</label>
<input type="text" name="lenghtofService" validate="length of service , string,no" id="lenghtofServiceId" value="<%=serviceYear+""+servicePeriod%>" />

<label> Marital Status</label>
<input  type="text" name="maritalStatus" validate="name , string,no" id="maritalStatusId" value="<%=maritalStatus %>" />
</div>
<!--<label>Unit/Ship</label>
<input type="text" name="unit/Ship" validate="unit , string,no" id="unit/ShipId" value="<%=unitName%>" />
-->
<!--<label>Residence</label> 
<input type="text" name="residence" validate="unit , string,no" id="residence" value="<%=residence %>" />

-->


