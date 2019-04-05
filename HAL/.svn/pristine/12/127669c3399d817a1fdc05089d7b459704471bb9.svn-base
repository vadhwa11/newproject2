<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * unit.jsp  
 * Purpose of the JSP -  This is for WardImpanneledHospital.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.9
--%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasWardImpanneledHospital"%>
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
ArrayList searchWardImpanneledHospitalList = (ArrayList)map.get("searchWardImpanneledHospitalList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

List<MasImpanneledHospital> impanneledHospitalList = new ArrayList<MasImpanneledHospital>();
impanneledHospitalList = (ArrayList)map.get("impanneledHospitalList");

System.out.println("searchWardImpanneledHospitalList"+searchWardImpanneledHospitalList.size());

%>
<% 
 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   

<h2><span><%=message%></span></h2>
			 	 
	<div class="Clear"></div>
		<%   
		  }
%>
<div class="titleBg">
<h2>Ward Of Impanneled  </h2>
</div>
<div id="searcharea">
<form name="search" method="post" action="">
	  <div class="Block">		    
			    	<label>Impanneled Hospital </label>
<select name="impanneledHospitalSearch" validate="Impanneled Hospital ,string,no" tabindex=1>
<option value="0">Select</option>
	<% 
				for (MasImpanneledHospital  mih : impanneledHospitalList){
				%>
<option value="<%=mih.getId()%>"><%=mih.getImpanneledHospitalName()%></option>
	<%}%>
</select>
				 
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchWardImpanneledHospital')" tabindex=1  />
                  <%--   Report Button --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="wardOfImpanneled">  
                    </div>
		     </form>
		 </div>
		


			 	 
	<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchWardImpanneledHospitalList.size()>0)
		 {
			String impanneledHospitalName = (String)map.get("impanneledHospitalName");
			if(impanneledHospitalName!=null)
			{
	%> 
		
    
   <h4> <a href="generalMaster?method=showWardImpanneledHospitalJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchWardImpanneledHospitalList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="generalMaster?method=showWardImpanneledHospitalJsp">Show All Records</a></h4>

	 <%
     }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"],[2,"impanneledHospital"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
	</div>
	
  <form name="wardImpanneledHospital" method="post" action="">
  <div class="Clear"></div>	  		
 	<div class="Block">

	  	
  		<label >Ward Name <span>*</span> </label>
			<input type="text" name="<%= SEARCH_NAME %>" validate="Ward Name,string,yes"  MAXLENGTH="299" tabindex=1 />
			<script>
				document.wardImpanneledHospital.<%=SEARCH_NAME%>.focus();
			</script>
	
			
			<label>Impanneled Hospital  <span>*</span></label>
<select name="impanneledHospital" validate="Impanneled Hospital ,string,yes" tabindex=1>
<option value="0">Select</option>
	<% 
				for (MasImpanneledHospital  mih : impanneledHospitalList){
				%>
<option value="<%=mih.getId ()%>"><%=mih.getImpanneledHospitalName()%></option>
	<%}%>
</select>
			</div>
<div class="Clear"></div>
			<div id="edited"></div>
			<div class="division"></div>
			<div class="Clear"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('wardImpanneledHospital','generalMaster?method=addWardImpanneledHospitalJsp');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('wardImpanneledHospital','generalMaster?method=editWardImpanneledHospital')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('wardImpanneledHospital','generalMaster?method=deleteWardImpanneledHospital&flag='+this.value)" accesskey="d" tabindex=1/>		
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
data_header[0][0] = "Ward Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"


	data_header[1] = new Array;
data_header[1][0] = "Impanneled Hospital "
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "impanneledHospital";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "0";
data_header[3][3] = "<%= CHANGED_DATE %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchWardImpanneledHospitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasWardImpanneledHospital  masWardImpanneledHospital = (MasWardImpanneledHospital)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
<%if(masWardImpanneledHospital.getId() != null) {%>
     data_arr[<%= counter%>][0] = <%= masWardImpanneledHospital.getId()%>
<%}%>
<%if(masWardImpanneledHospital.getWardName() != null){%>  
     data_arr[<%= counter%>][1] = "<%=masWardImpanneledHospital.getWardName()%>"
<%}%>



<%
		Iterator itrGridImpanneledHospitalList=impanneledHospitalList.iterator();
		 while(itrGridImpanneledHospitalList.hasNext())
            {try{
             MasImpanneledHospital  masImpanneledHospital = (MasImpanneledHospital)itrGridImpanneledHospitalList.next(); 
			 if(masWardImpanneledHospital.getImpanneledHospital().getId().equals(masImpanneledHospital.getId()) && masImpanneledHospital.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=masImpanneledHospital.getImpanneledHospitalName()%>"
			<%}else if(masWardImpanneledHospital.getId().equals(masImpanneledHospital.getId()) && masImpanneledHospital.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masImpanneledHospital.getImpanneledHospitalName()%>";
				
			<%}
            }catch(Exception e){}}%>

<%if(masWardImpanneledHospital.getLastChgBy() != null){%>
    data_arr[<%= counter%>][3] = "<%= masWardImpanneledHospital.getLastChgBy() %>"
<%}%>
<%if(masWardImpanneledHospital.getLastChgDate() != null){%>
    data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masWardImpanneledHospital.getLastChgDate()) %>"
<%}%>

<%if(masWardImpanneledHospital.getLastChgTime() != null){%>
    data_arr[<%= counter%>][5] = "<%= masWardImpanneledHospital.getLastChgTime() %>"
<%}%>

<%if(masWardImpanneledHospital.getStatus() != null){
if(masWardImpanneledHospital.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}}%>
<%
		     counter++;
}
%>
 
formName = "wardImpanneledHospital"
//nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  