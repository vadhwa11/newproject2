
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseTradeValidate.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  
 * @author  
 * Create Date: 28th january,2010
 * Revision Date:      
 * Revision By: 
 * @version   
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.Patient" %>
<%@page import="jkt.hms.masters.business.Inpatient" %>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%
	Map map = new HashMap();
    Box box = HMSUtil.getBox(request);
  List<MasTrade> masTradeList = new ArrayList<MasTrade>();
  List<Patient> patientList= new ArrayList<Patient>();
  List<Inpatient> inPatientList= new ArrayList<Inpatient>();
  List<MasTrade> allTradeList = new ArrayList<MasTrade>();
  List<EmpAfmsfDet> empAfmsfListOfTrade = new ArrayList<EmpAfmsfDet>();
  List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
    if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("tradeList") != null)	{
		masTradeList = (List<MasTrade>)map.get("tradeList");
	}
	if(map.get("patientDetailsList") != null)	{
		patientList = (List<Patient>)map.get("patientDetailsList");
	}
	if(map.get("inPatientList") != null)	{
		inPatientList = (List<Inpatient>)map.get("inPatientList");
	} 
	if(map.get("allTradeList") != null)	{
		allTradeList = (List<MasTrade>)map.get("allTradeList");
	}
	if(map.get("employeeList") != null)	{
		employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	System.out.println("employeeList------------------"+employeeList.size());
	if(map.get("empAfmsfListOfTrade") != null)	{
		empAfmsfListOfTrade = (List<EmpAfmsfDet>)map.get("empAfmsfListOfTrade");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
 System.out.println("list data in jsp:::::::"+masTradeList.size());
	if(masTradeList.size() > 0 ){
		MasTrade masTrade=masTradeList.get(0);
%> 

<div class="Block">
<label class="">Trade Name </label> 
<input id="tradeName" type="text" name="tradeName" class="large" value="<%= masTrade.getTradeName()%>"  validate="Trade Name,string,no" maxlength="30" />
<input type="hidden" name="tradeCode" value="<%=masTrade.getId()%>"  id="tradeCode"/>	


<div class="clear"></div>

<label>New Trade Name </label>
<select id="newTradeId" class="large" name="newTradeId" onchange="displayTradeAddress(this.value);" onblur="displayTradeAddress(this.value);">
<option value="">Select Trade Name</option>
		 <%
		  for (MasTrade trade :allTradeList) 
		  {
		 %>
<option value="<%=trade.getId()%>"> <%=trade.getTradeName()%></option>	
		 <%
		  }
		 %>
</select>
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForTrade();"
	title="Click here to Search ICD Codes"> 

<div class="clear"></div>

<!--  <label>Local Trade:</label>
<input type="checkbox" class="radio" id="sLocalTrade" name="sLocalTrade" readonly="readonly"/>
-->
</div>
<div class="clear"></div>	
<h4>Patient</h4>
 <div class="tableHholderCmnLarge">
  <table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <%
  	int inc=1;
  	System.out.println("patientList.size  ===================="+patientList.size());
  	if (patientList != null && patientList.size() > 0){
  %>
   <thead>
    <tr>
      <th width="20%" >Service No</th>
      <th width="40%" class="">Service Person Name</th>
      <th width="45%" class="">Admission No</th>
      <th width="10%" class=""> </th>
    </tr>
  </thead>
  <tbody>
    <%
		 for (Patient patientdetails : patientList) {
	%>
        <tr id="" onmouseover="" onmouseout="" onclick="">
	 	<td height="12"><%=patientdetails.getServiceNo()%></td>
		<td height="12"><%=patientdetails.getSFirstName()+" "+ patientdetails.getSMiddleName()+" "+patientdetails.getSLastName()%></td>
	 	<td>
	 	<%
	 	
	 	for(Inpatient inpatientdetails :inPatientList){
			if(inpatientdetails.getHinNo().equals(patientdetails.getHinNo())){%>
		   <%=inpatientdetails.getAdNo()%>
		 <% 
		  }
	 	}	
	   %> </td>
	  	 <td height="12"> <input type="checkbox" class="checkbox" id="newLocalTrade<%=inc%>" name="newLocalTrade" value="<%=patientdetails.getId()%>" /></td>
	  	
			 </tr>
		 <%	inc++;}
		%>
		<script>
		document.getElementById("chackLength").value =<%=inc-1%>
		 document.getElementById('deleteTradeId').style.display = 'none';
		</script> 
	 </tbody>
  	
    <%	}else{ %>
    	<tbody>
		  <tr>
		  <input type="hidden" id="newLocalTrade" name="newLocalTrade" value=""/>
		   
	      <td height="16" colspan=6 align="center"> No Data Found </td>
	      </tr>
	   
	       </tbody>
	       <script>
	       document.getElementById('deleteTradeId').style.display = 'block';
	       </script>
		 <%}%>
		 <input type="hidden" id="chackLength" name="chackLength" value=""/>
		  <input type="hidden" id="counter" name="counter" value="<%=inc%>"/>

 </table>
 </div>
 <div class="tableHholderCmnLarge">
<h4>Employee</h4>
 <table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <%
  	int i=1;
  	System.out.println("patientList.size  ===================="+patientList.size());
  	if (employeeList != null && employeeList.size() > 0){
  %>
   <thead>
    <tr>
      <th width="20%" >Service No</th>
      <th width="40%" class="">Service Person Name</th>
      <th width="55%" class=""> </th>
    </tr>
  </thead>
  <tbody>
    <%
		 for (MasEmployee masEmployee : employeeList) {
	%>
        <tr id="" onmouseover="" onmouseout="" onclick="">
	 	<td height="12"><%=masEmployee.getServiceNo()%></td>
		<td height="12"><%=masEmployee.getFirstName()+" "+ masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></td>
	 	
	 	<%
	 	
	 	//for(Inpatient inpatientdetails :inPatientList){
			//if(inpatientdetails.getHinNo().equals(patientdetails.getHinNo())){
		  // inpatientdetails.getAdNo()
		// 
		//  }
	 //	}	
	  // %> 
	  	 <td height="12"> <input type="checkbox" class="checkbox" id="newLocalTradeEmpAfmsf<%=i%>" name="newLocalTradeEmpAfmsf" value="<%=masEmployee.getId()%>" /></td>
	  	
			 </tr>
		 <%	i++;}
		%>
		<script>
		document.getElementById("chackLength").value =<%=i-1%>
		 document.getElementById('deleteTradeId').style.display = 'none';
		</script> 
	 </tbody>
  	
    <%	}else{ %>
    	<tbody>
		  <tr>
		  <input type="hidden" id="newLocalTrade" name="newLocalTrade" value=""/>
		   
	      <td height="16" colspan=6 align="center"> No Data Found </td>
	      </tr>
	   
	       </tbody>
	       <script>
	       document.getElementById('deleteTradeId').style.display = 'block';
	       </script>
		 <%}%>
		 <input type="hidden" id="chackLength" name="chackLength" value=""/>
		  <input type="hidden" id="counter" name="counter" value="<%=i%>"/>

 </table>
 

 </div>
<div class="clear"></div>
<% } %>
<div class="clear"></div>