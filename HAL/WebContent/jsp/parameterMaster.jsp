<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp  
 * Purpose of the JSP -  This is for Parameter Details.
 * @author  Dipali
 * Create Date: 03 Nov,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.15  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>
<%@page import="jkt.hms.masters.business.MasParameter"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
	List<MasSubChargecode> subChargeList = new ArrayList<MasSubChargecode>();
	ArrayList searchParameterList = (ArrayList)map.get("searchParameterList");
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	subChargeList = (ArrayList)map.get("subChargeList");
	serviceStatusList = (ArrayList)map.get("serviceStatusList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
 %>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }
%> 
 
<div class="titleBg"><h2>Parameter Master</h2></div>
<div class="Clear"></div>

	<jsp:include page="searchResultBlock.jsp" />
	<div class="Clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SUB_CHARGECODE_ID%>"], [2,"<%= SERVICE_STATUS_ID %>"],[3,"<%= MONTHLY%>"], [4,"<%= YEARLY %>"],[5,"<%= CONTINUOUS %>"],[6,"<%=CHANGED_BY%>"],[7,"<%= CHANGED_DATE%>"], [8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	</script>
	</div>
<div class="Clear"></div>
  <form name="masParameter" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasParameter">
  <input type="hidden" name="title" value = "Parameter">
  <input type="hidden" name="<%=JSP_NAME %>" value = "parameterMaster">
	  		
<div class="Block">			
			<label>Sub Charge</label>
			<select name="<%= SUB_CHARGECODE_ID %>" tabindex=1>
              <option value="0">Select</option>
              <% 
				for (MasSubChargecode  masSubChargecode : subChargeList){
				%>
              <option value="<%=masSubChargecode.getId ()%>"><%=masSubChargecode.getSubChargecodeName()%></option>
              <%}%>
            </select>
			<label>Service Status</label>
			<select name="<%= SERVICE_STATUS_ID %>"tabindex=1 >
			<option value="0">Select</option>
			  <% 
				for (MasServiceStatus  masServiceStatus : serviceStatusList){
				%>
			  <option value="<%=masServiceStatus.getId ()%>"><%=masServiceStatus.getServiceStatusName()%></option>
			  <%}%>
			</select>
			<div class="Clear"></div>
			 <label>Monthly</label>
			 <input type="checkbox" name="<%=MONTHLY%>" value="y" class="checkbox">
			 
			 <label>Yearly</label>
			 <input type="checkbox" name="<%=MONTHLY%>" value="y" class="checkbox">
			 
			 <label>Continuous</label>
			 <input type="checkbox" name="<%=CONTINUOUS%>" value="y" class="checkbox" checked="checked">
			<div class="Clear"></div>
	</div>
		<div class="Clear"></div>
		<div class="division"></div>
		<div id="edited"></div>
		<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="if(checkBlankForOphthalmology('masParameter')){submitForm('masParameter','laboratory?method=addParameterMaster');}" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('masParameter','laboratory?method=editParameterMaster')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('masParameter','laboratory?method=deleteParameterMaster&flag='+this.value)" accesskey="d" tabindex=1/>
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
		
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By:</label>   
			<label class="value"><%=userName%></label>			        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>			 
			<label>Changed Time: </label>   
			<label class="value"><%=time%></label>			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" /> 
			<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
<div class="Clear"></div>
	</div>
	</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Sub Charge"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= SUB_CHARGECODE_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Service Status"
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= SERVICE_STATUS_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Monthly "
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=MONTHLY %>";

data_header[3] = new Array;
data_header[3][0] = "Yearly"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= YEARLY %>"

data_header[4] = new Array;
data_header[4][0] = "Continuous"
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CONTINUOUS %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchParameterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasParameter  masParameter = (MasParameter)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masParameter.getId()%>

<%
		Iterator itrGridSubChargeList=subChargeList.iterator();
		 while(itrGridSubChargeList.hasNext())
            {try{
             MasSubChargecode  subChargeGrid = (MasSubChargecode)itrGridSubChargeList.next(); 
			 if(masParameter.getSubCharge().getId().equals(subChargeGrid.getId()) && subChargeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][1] = "<%=subChargeGrid.getSubChargecodeName()%>"
			<%}else if(masParameter.getId().equals(subChargeGrid.getId()) && subChargeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=subChargeGrid.getSubChargecodeName()%>";
				
		<%}
         
  }catch(Exception e){e.printStackTrace();}}%>
      
     <%
		Iterator itrGridServiceStatusList=serviceStatusList.iterator();
		 while(itrGridServiceStatusList.hasNext())
            {try{
             MasServiceStatus  serviceStatusGrid = (MasServiceStatus)itrGridServiceStatusList.next(); 
			 if(masParameter.getServiceStatus().getId().equals(serviceStatusGrid.getId()) && serviceStatusGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=serviceStatusGrid.getServiceStatusName()%>"
			<%}else if(masParameter.getId().equals(serviceStatusGrid.getId()) && serviceStatusGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=serviceStatusGrid.getServiceStatusName()%>";
				
		<%}
           }catch(Exception e){e.printStackTrace();}}%>
           
           data_arr[<%= counter%>][3] = "<%= masParameter.getMonthly() %>"
           data_arr[<%= counter%>][4] = "<%= masParameter.getYearly() %>"
           data_arr[<%= counter%>][5] = "<%= masParameter.getContinuous() %>"
data_arr[<%= counter%>][6] = "<%= masParameter.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masParameter.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= masParameter.getLastChgTime() %>"
<% if(masParameter.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "masParameter"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
