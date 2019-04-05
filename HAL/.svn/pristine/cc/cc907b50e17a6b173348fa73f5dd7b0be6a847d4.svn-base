<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>

<%
System.out.println("response ForService No Sho");
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
String trade = "";
String relation = "";
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
		 trade = dependentList.get(0).getTrade().getTradeName() ;
		 relation = dependentList.get(0).getRelation().getRelationName(); 
		// String hin_id=dependentList.get(0).getHinNo().
		 
}
%>
<%
	 
		for(Patient patient: dependentList)
		{
			int hinId=patient.getId();
			System.out.println("hinId--------------->>>>>hinId in ResponseForADS"+hinId);
			%>
			
			<input type="hidden" name="hinId" value=<%=hinId %>  />
		  <%} %>
<div id="srNoDiv">
<label>Service No. </label>
<input type="text" name="serviceNo"  validate="Service No,alphanumeric,yes"  id="serviceNoId" value="<%=serviceNo %>"
    onblur="getPatientDetails(this.value);"  />
    <label>Name</label>
     <input type="text" name="name" id="nameId"  validate="name, string,no" value="<%=patientName%>" /> 
     <label>Relation</label>
   <input type="text" name="relation" id="relation" validate="Relation,String,Yes" value="<%=relation %>"  /> 
    <div class="clear"></div>
     <label>Rank</label>
   <input type="text" name="rank"  validate="rank, number,no" id="rank/RateId" value="<%=patientRankName%>" />
   <label>Age</label>
    <input type="text" name="age" validate="age , number,no" id="ageId" value="<%=age%>" />

  <label>Branch/Trade</label>	
   <input  type="text" name="branch" validate="name, string, no" id="tradeId" value="<%=trade %>" />
  <div class="clear"></div>
   <label>Unit</label>
<input type="text" name="unit" validate="unit , string,no" id="unit/ShipId" value="<%=unitName%>" />


</div>


