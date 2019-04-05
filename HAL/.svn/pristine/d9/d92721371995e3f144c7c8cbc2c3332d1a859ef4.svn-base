<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * biopsyLab.jsp  
 * Purpose of the JSP -  This is for Biopsy Lab.
 * @author  Dipali
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.12  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchCollectionCenterList = (ArrayList)map.get("searchCollectionCenterList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>
<div class="titleBg"><h2>Collection Center</h2></div>
<div class="Clear"></div>
	  <div id="searcharea">	  
		  <div id="searchbar">		  
			  <form name="search" method="post" action="">
			    	<div class="Block">
			    	<label class="auto">CollectionCenter Code</label>
			    	<input type="radio" class="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
					<label class="auto">CollectionCenter Name</label>
					<input type="radio" class="radio" name="<%=SELECTED_RADIO %>" value="2"  />
					
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="CollectionCenter Code,string,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'laboratory?method=searchCollectionCenter')" />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchCollectionCenter','checkSearch')" tabindex=1  />
		    <div class="Clear"></div>
		    </div>		    
		     </form>
		        </div>  
 </div>
  <div class="Clear"></div>
      
	 <jsp:include page="searchResultBlock.jsp" />
	   <div class="Clear"></div>
 <div id="searchresults" tabindex=2 >
 <div id="searchtable" tabindex=2 ></div>
	<% 
		if(searchCollectionCenterList.size()>0)
		 {
			String strForCode = (String)map.get("collectionCenterCode");
			String strForCodeDescription = (String)map.get("collectionCenterName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	  
    <h4><a href="laboratory?method=showCollectionCenterJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchCollectionCenterList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="laboratory?method=showCollectionCenterJsp">Show All Records</a></h4>

	 <%
     }
	%>

 <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
 </div>
   <div class="Clear"></div>
  <form name="collectionCenter" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasBiopsyLab">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BiopsyLabName">
  <input type="hidden" name="title" value = "BiopsyLab">
  <input type="hidden" name="<%=JSP_NAME %>" value = "biopsyLab">
  <input type="hidden" name="pojoPropertyCode" value = "BiopsyLabCode">		  	 
     
  <div class="Block">
	  	<label class="auto"> CollectionCenter Code <span>*</span></label>
		<input id="codeId" type="text" name="<%= CODE%>" value="" validate="CollectionCenter Code,string,yes"  MAXLENGTH="8"/ tabindex=1 >
  		<label class="auto" >CollectionCenter Name <span>*</span></label>
		<input type="text" name="<%= SEARCH_NAME %>" value="" validate="CollectionCenter Name,string,yes"  MAXLENGTH="30"/ tabindex=1 onkeypress="return submitenter(this,event,'laboratory?method=addCollectionCenter')">
		<script>
				document.collectionCenter.<%=CODE%>.focus();
		</script>			
		</div>						
			<div class="Clear"></div>
			<div class="division"></div>			  
			<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('collectionCenter','laboratory?method=addCollectionCenter');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('collectionCenter','laboratory?method=editCollectionCenter')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('collectionCenter','laboratory?method=deleteCollectionCenter&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />			  
		
			 <div class="Clear"></div>
			 <div class="division"></div>
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
			<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" />
			</div>	 	
	        <div class="Clear"></div>							
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "CollectionCenter Code"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "CollectionCenter Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();
<%

Iterator itr=searchCollectionCenterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             DgCollectionCenter  dgCollectionCenter = (DgCollectionCenter)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= dgCollectionCenter.getId()%>
data_arr[<%= counter%>][1] = "<%=dgCollectionCenter.getCollectionCenterCode()%>"
data_arr[<%= counter%>][2] = "<%= dgCollectionCenter.getCollectionCenterName()%>"
data_arr[<%= counter%>][3] = "<%= dgCollectionCenter.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(dgCollectionCenter.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= dgCollectionCenter.getLastChgTime() %>"
<% if(dgCollectionCenter.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "collectionCenter"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  