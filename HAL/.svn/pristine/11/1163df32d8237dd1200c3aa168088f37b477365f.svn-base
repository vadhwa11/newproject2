<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * unit.jsp  
 * Purpose of the JSP -  This is for Unit.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.9
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasStation"%>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchUnitList = (ArrayList)map.get("searchUnitList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
List<MasStation> stationList = new ArrayList<MasStation>();
stationList = (ArrayList)map.get("stationList");


ArrayList gridStationList = (ArrayList)map.get("gridStationList");


%>
<% 
 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   

<label class="noWidth"><span><%=message%></span></label>
		<%   
		  }
%>
<div class="titleBg">
<h2>Unit Master</h2>
</div>
<div id="searcharea">
<form name="search" method="post" action="">
	  <div class="Block">		    
			    	<label>Unit Name</label>
					 <input type="text" id="searchField" name="<%= SEARCH_NAME%>" value=""  validate="Unit Name,string,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=searchUnit')" />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchUnit','checkSearch')" tabindex=1  />
                    <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_unit">
                    </div>
		     </form>
		 </div>
		


			 	 
	<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchUnitList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("unitName");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%> 
		
    
   <h4> <a href="personnel?method=showUnitJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchUnitList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="personnel?method=showUnitJsp">Show All Records</a></h4>

	 <%
     }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"<%= UNIT_ADDRESS %>"], [3,"<%= LOCAL_UNIT%>"],[4,"<%= STATION_ID%>"], [5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script>
	</div>
	
  <form name="unit" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasUnit">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="UnitName">
  <input type="hidden" name="title" value = "Unit">
  <input type="hidden" name="<%=JSP_NAME %>" value = "unit">
  <input type="hidden" name="pojoPropertyName" value = "UnitName">
<div class="Clear"></div>	  		
 	<div class="Block">

	  	
  		<label >Unit Name <span>*</span> </label>
			<input type="text" name="<%= SEARCH_NAME %>" validate="Unit Name,string,yes"  MAXLENGTH="30" tabindex=1 />
			<script>
				document.unit.<%=SEARCH_NAME%>.focus();
			</script>
			<label > Unit Address <span>*</span> </label>
		   <input type="text" class="large" name="<%= UNIT_ADDRESS%>" value="" validate="Unit Address,string,yes"  MAXLENGTH="50" tabindex=1 />
		
		  <label >Local Unit</label>
				<input type="checkbox" class="radio" name="<%=LOCAL_UNIT %>" value="y" onkeypress="return submitenter(this,event,'personnel?method=addUnit')">
			
			
			
			
			<label>Station <span>*</span></label>
<select name="<%= STATION_ID %>" validate="Station,string,yes" tabindex=1>
<option value="0">Select</option>
	<% 
				for (MasStation  masStation : stationList){
				%>
<option value="<%=masStation.getId ()%>"><%=masStation.getStationName()%></option>
	<%}%>
</select>
			</div>
<div class="Clear"></div>
			<div id="edited"></div>
			<div class="division"></div>
			<div class="Clear"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('unit','personnel?method=addUnit');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('unit','personnel?method=editUnit')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('unit','personnel?method=deleteUnit&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			<div class="Clear"></div>
			<div class="division"></div>
			<div class="Clear"></div>
<div class="bottom">
<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />	   			
   </div>
   </form>	
	

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Unit Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Unit Address"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= UNIT_ADDRESS %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= LOCAL_UNIT %>"

	data_header[3] = new Array;
data_header[3][0] = "Station "
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=STATION_ID %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%= CHANGED_DATE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchUnitList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasUnit  masUnit = (MasUnit)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
<%if(masUnit.getId() != null) {%>
     data_arr[<%= counter%>][0] = <%= masUnit.getId()%>
<%}%>
<%if(masUnit.getUnitName() != null){%>  
     data_arr[<%= counter%>][1] = "<%=masUnit.getUnitName()%>"
<%}%>
<%if(masUnit.getUnitAddress() != null){%>
     data_arr[<%= counter%>][2] = "<%= masUnit.getUnitAddress()%>"
 <%}%>
<%if(masUnit.getLocalUnit() != null){%>     
    data_arr[<%= counter%>][3] = "<%= masUnit.getLocalUnit() %>"
<%}%>


<%
		Iterator itrGridStationList=gridStationList.iterator();
		 while(itrGridStationList.hasNext())
            {try{
             MasStation  stationGrid = (MasStation)itrGridStationList.next(); 
			 if(masUnit.getStation().getId().equals(stationGrid.getId()) && stationGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=stationGrid.getStationName()%>"
			<%}else if(masUnit.getId().equals(stationGrid.getId()) && stationGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=stationGrid.getStationName()%>";
				
			<%}
            }catch(Exception e){}}%>

<%if(masUnit.getLastChgBy() != null){%>
    data_arr[<%= counter%>][5] = "<%= masUnit.getLastChgBy() %>"
<%}%>
<%if(masUnit.getLastChgDate() != null){%>
    data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masUnit.getLastChgDate()) %>"
<%}%>

<%if(masUnit.getLastChgTime() != null){%>
    data_arr[<%= counter%>][7] = "<%= masUnit.getLastChgTime() %>"
<%}%>

<%if(masUnit.getStatus() != null){
if(masUnit.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}}%>
<%
		     counter++;
}
%>
 
formName = "unit"
//nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  