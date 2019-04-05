<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * labOrganismMst.jsp  
 * Purpose of the JSP -  This is for Organism Description Master.
 * @author  Vishal Jain
 * Create Date: 06th August,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.DgMasOrganism"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script>
<%
  	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%

Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchOrganismList = (ArrayList)map.get("searchOrganismList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
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
 
<div class="titleBg"><h2>Organism</h2></div>
<div class="Clear"></div>
	  <div id="searcharea">
		  <div id="searchbar">		  
			  <form name="search" method="post" action="">
			    <div class="Block">
			    <label>Organism Code</label>
			    	<input type="radio" name="<%=SELECTED_RADIO  %>" class="radioAuto"  value="1" checked="checked" />
					<label>Organism Name</label>
					<input type="radio" name="<%=SELECTED_RADIO %>" class="radioAuto" value="2"  />				
					<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Organism Code,string,no"   MAXLENGTH="8" tabindex=1   onkeypress="return submitenter(this,event,'laboratory?method=searchOrganism')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchOrganism','checkSearch')" tabindex=1  />
                    <input type="button" name="report" value="Generate Report Based on Search" class="buttonBig2" onclick="submitForm('search','laboratory?method=generateReportForLabOrganismDesc')" tabindex=1  />
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="OrganismDescMaster">
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
 	
 	    if(searchOrganismList.size()>0 )
		 {			
			String strForCode = (String)map.get("organismCode");
			String strForCodeDescription = (String)map.get("organismName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{				
	%> 		
  
    <h4><a href="laboratory?method=showOrganismJsp">Show All Records</a></h4>
	<%
			}
		 }
		
	 if(searchOrganismList.size()==0 && map.get("search") != null)
	  {
		 
	 %>
				<h4><a href="laboratory?method=showOrganismJsp">Show All Records</a></h4>

	 <%
     }
	%>

	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"],[4,"<%= CHANGED_DATE%>"], [5,"<%= CHANGED_TIME %>"],[6,"<%= STATUS %>"]];
	 statusTd = 6;
	</script>
	</div>
	
  <form name="organism" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "DgMasOrganism">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="OrganismName">
  <input type="hidden" name="title" value = "organism">
  <input type="hidden" name="<%=JSP_NAME %>" value = "organism">
  <input type="hidden" name="pojoPropertyCode" value = "OrganismCode">
<div class="Clear"></div>

<div class="Block">
	  	<label >  Organism Code <span>*</span></label>
		<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Organism Code,string,yes"  MAXLENGTH="8" tabindex=1 />
		<label > Organism Name<span>*</span></label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Organism Name,string,yes"  MAXLENGTH="30" tabindex=1  onkeypress="return submitenter(this,event,'laboratory?method=addOrganism')" />
			<script>
				document.organism.<%=CODE%>.focus();
				</script>		
			</div>
			<div class="Clear"></div>
			
			<div class="division"></div>
				<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('organism','laboratory?method=addOrganism');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('organism','laboratory?method=editOrganism')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('organism','laboratory?method=deleteOrganism&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			<div class="Clear"></div>
			<div class="division"></div>
			
			<div class="bottom">			
		<label >Changed By:</label>   
		<label class="value"><%=userName %></label>
			        
		<label >Changed Date:</label>   
		<label class="value"><%=date%></label>
			 
		<label >Changed Time:</label>   
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
		data_header[0][0] = "Organism Code"
		data_header[0][1] = "data";
		data_header[0][2] = "25%";
		data_header[0][3] = "<%= CODE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Organism Name"
		data_header[1][1] = "data";
		data_header[1][2] = "40%";
		data_header[1][3] = "<%= SEARCH_NAME %>";
		
		data_header[2] = new Array;
		data_header[2][0] = ""
		data_header[2][1] = "hide";
		data_header[2][2] = "35%";
		data_header[2][3] = "<%= CHANGED_BY %>";
		
		data_header[3] = new Array;
		data_header[3][0] = ""
		data_header[3][1] = "hide";
		data_header[3][2] = 0;
		data_header[3][3] = "<%= CHANGED_DATE%>"
		
		data_header[4] = new Array;
		data_header[4][0] = ""
		data_header[4][1] = "hide";
		data_header[4][2] = 0;
		data_header[4][3] = "<%= CHANGED_TIME%>"
		
		data_header[5] = new Array;
		data_header[5][0] = "Status"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=STATUS %>";
		
		data_arr = new Array();

	<%
	
	  
	Iterator itr = searchOrganismList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	             DgMasOrganism  dgMasOrganism = (DgMasOrganism)itr.next(); 
	%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] =  <%= dgMasOrganism.getId()%>
		data_arr[<%= counter%>][1] = "<%= dgMasOrganism.getOrganismCode()%>"
		data_arr[<%= counter%>][2] = "<%= dgMasOrganism.getOrganismName()%>"
		data_arr[<%= counter%>][3] = "<%= dgMasOrganism.getLastChgBy() %>"
		data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(dgMasOrganism.getLastChgDate())%>"
		data_arr[<%= counter%>][5] = "<%= dgMasOrganism.getLastChgTime() %>"
		<% if(dgMasOrganism.getStatus().equals("y")){ %>
		data_arr[<%= counter%>][6] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][6] = "InActive"
		<%}%>
		<%
				     counter++;
		}
		%>
 
		formName = "organism"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
		</script>	
	  