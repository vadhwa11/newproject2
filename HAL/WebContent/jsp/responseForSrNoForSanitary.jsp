<%@ page import ="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>


<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Patient"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<div class="clear"></div>

<%
System.out.println("response ForService No Sanitary");
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
String branch = "";
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
		branch = dependentList.get(0).getTrade().getTradeName();
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
			System.out.println("hinId in response Jsp sanitary=====********>>>>"+hinId);
			%>
			<input type="hidden" name="hinId" value=<%=hinId %>  />
		  <%} %>
		  
		  <div id="gridview">
     <table id="Grid">
        <tr>
        <th>Service No.</th>
		<th >Name</th>
		<th >Designation</th>
		<th >Branch/Trade</th>
		<th >Classification/Speciality</th>
		<th >Add</th>
		<th >Delete</th>
		</tr>
    <tr>
		<td>
		<input style="width: 80px" type="text" name="<%=SERVICE_NO %>"  id="serviceNoId" value=""
		 onblur="getPatientDetails(this.value);" />
		</td>		
        
		<td>
		<input style=" width: 190px"  type="text" name="nameofSanitaryRound"  id="nameofSanitaryRound" value="<%=patientName %>" />
		     
		</td>
		<td>
		<input style=" width: 190px"  type="text" name="sanitaryDesignation"  id="sanitaryDesignation" value="<%=patientRankName %>" />
                                 
		              
       </td>
       <td>
        <input style=" width: 120px" type="text" name="sanitaryBranch"  id="sanitaryBranch" value="<%=branch %>" />
		
          </td>
          <td>

        <input style=" width: 190px" type="text" name="sanitaryClassification" validate="name , string,no" id="sanitaryClassification" value="" />
	
		</td>
	
		<td><input name="buttonAdd" type="button" class="buttonAdd" value=""
			onclick="addRow();" /></td>
		<td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('investigationGrid','hiddenValue',this);" /></td>
</tr>
</table>
</div>

