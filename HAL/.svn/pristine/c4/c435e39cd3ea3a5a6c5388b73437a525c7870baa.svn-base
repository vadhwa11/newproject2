<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * therapyType.jsp  
 * Purpose of the JSP -  This is for Therapy Type.
 * @author  Ritu
 * Create Date: 28th Apr,2011 
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasTherapyType> searchTherapyTypeList = new ArrayList<MasTherapyType>();
	
	searchTherapyTypeList = (List<MasTherapyType>)map.get("searchTherapyTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	

%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   
<%@page import="jkt.hms.masters.business.MasTherapyType"%><h4><%=message %></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Therapy Type Master</h2>
</div>
	  <div id="searcharea">
	  
		
		  
			  <form name="search" method="post" action="">
			    <div class="Block">
			    <label>Therapy Code</label>
			    	<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
					<label>Therapy Name</label>
					<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />
					
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Title Code,metachar,no"   MAXLENGTH="8" tabindex=1   onkeypress="return submitenter(this,event,'physiotherapy?method=searchTherapyType')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','physiotherapy?method=searchTherapyType','checkSearch')" tabindex=1  />
		    
		     <div class="Clear"></div>
		 </div>
</form>


		
 </div>

			 	 
	<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchTherapyTypeList.size()>0)
		 {
			String strForCode = (String)map.get("therapyTypeCode");
			String strForCodeDescription = (String)map.get("therapyTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
		

    <h4><a href="physiotherapy?method=showTherapyTypeJsp">Show All Records</a></h4>
	<%
			}
		 }
	if(searchTherapyTypeList.size()==0 && map.get("search") != null)
	 {
	%>
				<h4><a href="physiotherapy?method=showTherapyTypeJsp">Show All Records</a></h4>

	<%
	 }
		%>

	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
	</div>
	
  <form name="therapyType" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasTherapyType">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TherapyTypeName">
  <input type="hidden" name="title" value = "Title">
  <input type="hidden" name="<%=JSP_NAME %>" value = "therapyType">
  <input type="hidden" name="pojoPropertyCode" value = "TherapyTypeCode">
		
	  		
	  		
	  		
 	<div class="Clear"></div>
<div class="Block">

	  	<label >  Therapy Type Code<span>*</span> </label>
		<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Therapy Type Code,metachar,yes"  MAXLENGTH="8"/ tabindex=1 >
		
  		<label > Therapy Type Name<span>*</span></label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Therapy Type Name,metachar,yes"  MAXLENGTH="30"/ tabindex=1  onkeypress="return submitenter(this,event,'generalMaster?method=addTitle')">
			<script>
				document.therapyType.<%=CODE%>.focus();
			</script>
			
			</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('therapyType','physiotherapy?method=addTherapyType');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('therapyType','physiotherapy?method=editTherapyType')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('therapyType','physiotherapy?method=deleteTherapyType&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			
		
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   </div>	
	<div class="Clear"></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Therapy Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Therapy Type Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = "Status"
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
Iterator itr=searchTherapyTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasTherapyType masTherapyType = (MasTherapyType)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masTherapyType.getId()%>
data_arr[<%= counter%>][1] = "<%=masTherapyType.getTherapyTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masTherapyType.getTherapyTypeName()%>"
<%if(masTherapyType.getLastChgBy()!= null){%>
data_arr[<%= counter%>][3] = "<%= masTherapyType.getLastChgBy().getUserName() %>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masTherapyType.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masTherapyType.getLastChgTime() %>"
<% if(masTherapyType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "Inactive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "therapyType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  