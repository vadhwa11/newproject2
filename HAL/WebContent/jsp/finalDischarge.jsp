<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : finalDischarge.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Discharge"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<div id="contentHolder">
<form name="finalDischargeSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("departmentList") != null){
			wardList = (List<MasDepartment>)map.get("departmentList");
		}
		if(patientMap.get("dischargeList") != null){
			dischargeList= (List<Discharge>)patientMap.get("dischargeList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script>

<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label>Service No:</label> <input
	type="text" name="<%=SERVICE_NO %>" value="" MAXLENGTH="30" /> <label>A&D
No:</label> <input type="text" name="<%=AD_NO %>" value="" MAXLENGTH="30" /> <label>Hin
No:</label> <input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="30" />
<div class="Clear"></div>

<label>Ward:</label> <select name="<%=WARD_ID %>">
	<option value="0"><--Select Ward--></option>
	<% 
     for(MasDepartment masDepartment : wardList){
    	 if(map.get("departmentId") != null ){
    		 int deptId = (Integer)map.get("departmentId");
    		 if(deptId == masDepartment.getId()){
    	%>
	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName() %></option>
	<%	 	}
    		 if(deptId != masDepartment.getId()){
      %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}
     }else{%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%	 
     }
     }
    	 %>
</select></div>


</form>
<br />

<input type="button" name="Search" id="addbutton"
	onclick="submitForm('finalDischargeSearch','/hms/hms/adt?method=showReadyToDischargeList');"
	value="Search" class="button" accesskey="a" />


<div class="Clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>

<form name="finalDischarge" method="post" action="">

<div id="test">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript">

   formFields = [
    [0, "<%= DISCHARGE_ID%>", "id"],[1,"<%= RADIO_FOR_TABLE%>"], [2,"<%= SERVICE_NO%>"], [3,"<%= SERVICE_TYPE_ID %>"],[4,"<%=AD_NO%>"], [5,"<%= HIN_NO %>"],[6,"<%=PATIENT_NAME  %>"],[7,"<%=WARD_NAME  %>"]];
     statusTd = 7;

   </script></div>
</div>

<div class="Clear"></div>


<input type="button" name="discharge" id="dischargeButton"
	style="display: none;" value="Discharge" class="button"
	onClick="submitForm('finalDischarge','adt?method=dischargePatient','validateRadio');"
	accesskey="a" tabindex=1 /> <input type="button" name="addInfo"
	id="addInfoId" style="display: none;" value="Add Info" class="button"
	onClick="if(validateRadio()){showAddInfoPopUp();}" accesskey="a"
	tabindex=1 /> <input type="button" name="yes" value="Print"
	class="button" id="dsPrint" style="display: none;"
	onclick="submitForm('finalDischarge','/hms/hms/ipd?method=showDischargeSlipReport','validateRadio');" />

<div class="Clear"></div>


<script type="text/javascript">
function showAddInfoPopUp(obj,objName){
	var url = '/hms/hms/adt?method=showAdditionalInfoJsp';
	newwindow=window.open(url,'name','left=200,top=100,width=800,height=250');
	
}
		
</script>
</div>

<script type="text/javascript">
    data_header = new Array();
        
   	data_header[0] = new Array;
	data_header[0][0] = "Radio"
	data_header[0][1] = "radio";
	data_header[0][2] = "4%";
	data_header[0][3] = "<%=RADIO_FOR_TABLE%>"
    
    data_header[1] = new Array;
    data_header[1][0] = "Service No."
    data_header[1][1] = "data";
    data_header[1][2] = "12%";
    data_header[1][3] = "<%=SERVICE_NO%>";
    
    data_header[2] = new Array;
    data_header[2][0] = "Service Type"
    data_header[2][1] = "data";
    data_header[2][2] = "15%";
    data_header[2][3] = "<%=SERVICE_TYPE_ID%>";
    
    data_header[3] = new Array;
    data_header[3][0] = "AD No."
    data_header[3][1] = "data";
    data_header[3][2] = "14%";
    data_header[3][3] = "<%=AD_NO%>";
    
    data_header[4] = new Array;
    data_header[4][0] = "Hin No."
    data_header[4][1] = "data";
    data_header[4][2] = "14%";
    data_header[4][3] = "<%=HIN_NO%>";
    
    data_header[5] = new Array;
    data_header[5][0] = "Patient Name"
    data_header[5][1] = "data";
    data_header[5][2] = "26%";
    data_header[5][3] = "<%=PATIENT_NAME%>";
    
   	data_header[6] = new Array;
    data_header[6][0] = "Ward"
    data_header[6][1] = "data";
    data_header[6][2] = "30%";
    data_header[6][3] = "<%=WARD_NAME%>";
     data_arr = new Array();
    
    <%
   
    int counter = 0;
    	if(dischargeList.size()>0)
    	{
    		for (Iterator iterator = dischargeList.iterator(); iterator.hasNext();) {
    			Discharge dischargeObj  = (Discharge) iterator.next();
				Patient patient = (Patient)dischargeObj.getHin();
				try{				
  	%>
		    	data_arr[<%= counter%>] = new Array();
				data_arr[<%= counter%>][0] = <%= dischargeObj.getId()%>
				data_arr[<%= counter%>][1] = '<input type="radio" id="parent" name="parent" value="<%= dischargeObj.getId()%>" id="parent"  />'
				data_arr[<%= counter%>][2] = "<%=patient.getServiceNo()%>"
				data_arr[<%= counter%>][3] = "<%= patient.getServiceType().getServiceTypeName()%>"
				data_arr[<%= counter%>][4] = "<%= dischargeObj.getAdNo() %>"
				data_arr[<%= counter%>][5] = "<%= patient.getHinNo() %>"
				data_arr[<%= counter%>][6] = "<%= patient.getPFirstName() %> <%= patient.getPMiddleName() %> <%= patient.getPLastName() %>"
				data_arr[<%= counter%>][7] = "<%= dischargeObj.getWard().getDepartmentName() %>"  
    		
  	<%}catch(Exception e){
  		e.printStackTrace();
  	}	
  	counter++;	
  				
    		}
    	}
 %>
     formName = "finalDischarge"
	 start = 0
    if(data_arr.length < rowsPerPage)
     end = data_arr.length;
    else
     end = rowsPerPage;
    
    makeTable(start,end);
    
    intializeHover('searchresulttable', 'TR', ' tableover');  
    </script>

