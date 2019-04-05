<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * recodrOfficeAddress.jsp  
 * Purpose of the JSP -  This is for keeping record of Office Address.
 * @author  Priyanka
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.6
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
	serviceTypeList = (ArrayList)map.get("serviceTypeList");
	ArrayList searchRecordOfficeAddressList = (ArrayList)map.get("searchRecordOfficeAddressList");
	ArrayList gridServiceTypeList = (ArrayList)map.get("gridServiceTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

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
<h2>Record Office Address Master</h2>
</div>
<div class="Clear"></div>
	  <div id="searcharea">
	  
		  
		  
			   <form name="search" method="post" action="">
			    <div class="Block">
			    		<label>RC Address</label>
					 <input type="text" id="searchField" name="<%= SEARCH_NAME%>" value=""  validate="RC Address,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'personnel?method=searchRecordOfficeAddress')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchRecordOfficeAddress','checkSearch')" tabindex=1  />
<%--- Report Button   --%> 
 <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_record_office_address">
		     </form>
<div class="Clear"></div>

		 </div>
		
 </div>

			<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchRecordOfficeAddressList.size()>0 && serviceTypeList.size() > 0)
		 {
			
			String strForCodeDescription = (String)map.get("recordOfficeAddress");
			if(strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	  <div class="Clear"></div>
   <h4> <a href="personnel?method=showRecordOfficeAddressJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchRecordOfficeAddressList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="personnel?method=showRecordOfficeAddressJsp">Show All Records</a></h4>

	 <%
     }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME %>"], [2,"<%= SERVICE_TYPE_ID %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
	</div>
<div class="Clear"></div>
  <form name="recordOfficeAddress" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasRecordOfficeAddress">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "Address">
  <input type="hidden" name="title" value = "RecordOfficeAddress">
  <input type="hidden" name="<%=JSP_NAME %>" value = "recordOfficeAddress">
  
<div class="Block">
	  	<label >  RC Address <span>*</span></label>
		<input type="text" name="<%= SEARCH_NAME%>" class="large2" value="" validate="RecordOfficeAddress Name,string,yes"  MAXLENGTH="8"/ tabindex=1 >
  			<script>
			</script>
			
			<label > Service Type <span>*</span></label>
			<select name="<%= SERVICE_TYPE_ID %>" validate="Service Type,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addRecordOfficeAddress')">
			<option value="">Select</option>
			  <% 
				
				for (MasServiceType  masServiceType : serviceTypeList){
				%>
			  <option value="<%=masServiceType.getId ()%>"><%=masServiceType.getServiceTypeName()%></option>
			  <%}%>
			</select>
			</div>
				<div class="Clear"></div>
			<div id="edited"></div>
			<div class="division"></div>
			<div class="Clear"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('recordOfficeAddress','personnel?method=addRecordOfficeAddress');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('recordOfficeAddress','personnel?method=editRecordOfficeAddress')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('recordOfficeAddress','personnel?method=deleteRecordOfficeAddress&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
						<div class="Clear"></div>
									<div class="division"></div>
			<div class="Clear"></div>
						
<div class="bottom">
<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 </div>
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />		   			
	   <div class="Clear"></div>
	</form>
	
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "RC Address "
data_header[0][1] = "data";
data_header[0][2] = "40%";
data_header[0][3] = "<%= SEARCH_NAME %>";

data_header[1] = new Array;
data_header[1][0] = "Service Type "
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SERVICE_TYPE_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchRecordOfficeAddressList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasRecordOfficeAddress  masRecordOfficeAddress = (MasRecordOfficeAddress)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masRecordOfficeAddress.getId()%>
data_arr[<%= counter%>][1] = "<%= masRecordOfficeAddress.getAddress()%>"
<%
		Iterator itrGridServiceTypeList=gridServiceTypeList.iterator();
		 while(itrGridServiceTypeList.hasNext())
            {try{
             MasServiceType  serviceTypeGrid = (MasServiceType)itrGridServiceTypeList.next(); 
			 if(masRecordOfficeAddress.getServiceType().getId().equals(serviceTypeGrid.getId()) && serviceTypeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=serviceTypeGrid.getServiceTypeName()%>"
			<%}else if(masRecordOfficeAddress.getId().equals(serviceTypeGrid.getId()) && serviceTypeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=serviceTypeGrid.getServiceTypeName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
           
data_arr[<%= counter%>][3] = "<%= masRecordOfficeAddress.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masRecordOfficeAddress.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masRecordOfficeAddress.getLastChgTime() %>"
<% if(masRecordOfficeAddress.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "recordOfficeAddress"
nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  