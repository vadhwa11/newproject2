<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hrQualificationMaster.jsp  
 * Purpose of the JSP -  This is for Qualification Master details 
 * @author  Rajendra
 * Create Date: 12th Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>

<%@page import="jkt.hms.masters.business.HrMasQualification"%>



<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	

	List<HrMasQualification> searchQualificationMasterList = new ArrayList<HrMasQualification>();
			
	if (map.get("searchQualificationMasterList") != null)
	{
		searchQualificationMasterList = (List)map.get("searchQualificationMasterList");
	}
				
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		 %>
		 <h4><%=message %></h4>  
		 <% }%>

	
<div class="titleBg"><h2>Qualification Master</h2></div>

<div class="Block">	 
 <div id="searcharea">
  <div id="searchbar">
			   <form name="search" method="post" action="">
	
			    	<label>Qualification Code</label>
			    	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
					
					<label>Qualification Name</label>
					<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"  />
					
					
					<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Qualification Code,string,no"   MAXLENGTH="8" tabindex=1  />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','systemRelatedMaster?method=searchQualificationMaster','checkSearch')" tabindex=1  />
  
		     </form>
		 </div>
 </div>
 <div class="clear"></div>
</div>		
<form name="ancher" method="post">
</form>
<div class="clear"></div>
<div class="division"></div>
	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
 
	<% 
		if(searchQualificationMasterList.size()>0 )
		 {
			String strForCode = (String)map.get("qualificationCode");
			String strForCodeDescription = (String)map.get("qualificationName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	
                <!-- <h4><a href="systemRelatedMaster?method=showQualificationMasterJsp">Show All Records</a></h4> -->
                 <h4><a href="javascript:void(0)" onclick="submitForm('ancher','systemRelatedMaster?method=showQualificationMasterJsp');">Show All Records</a></h4>
	<%
			}
		 }
	if(searchQualificationMasterList.size()==0 && map.get("search") != null)
	  {
    %>
				 <!-- <h4><a href="systemRelatedMaster?method=showQualificationMasterJsp">Show All Records</a></h4> -->
				  <h4><a href="javascript:void(0)" onclick="submitForm('ancher','systemRelatedMaster?method=showQualificationMasterJsp');">Show All Records</a></h4>

    <%
           }
         %>

	<script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
	</div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="Block">	
	<form name="qualification" method="post" action="">
	<input type="hidden" name="<%= POJO_NAME %>" value = "HrMasQualification">
	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "QualificationName">
	<input type="hidden" name="title" value = "Qualification">
	<input type="hidden" name="<%=JSP_NAME %>" value = "hrQualificationMaster">
	<input type="hidden" name="pojoPropertyCode" value = "QualificationCode">
		
 		
        <label><span>*</span> Qualification Code</label>
	  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Qualification Code,string,yes" MAXLENGTH="8" tabindex=1 >
  		<label><span>*</span> Qualification Name</label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Qualification Name,string,yes" MAXLENGTH="200" tabindex=1 >
			<script>
				document.qualification.<%=CODE%>.focus();
			</script>
		<div class="clear"></div>
		
		
		 	<div class="division"></div>
			<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('qualification','systemRelatedMaster?method=addQualificationMaster');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('qualification','systemRelatedMaster?method=editQualificationMaster')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('qualification','systemRelatedMaster?method=deleteQualificationMaster&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
            
            <div class="division"></div>
			<div class="bottom">
			<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   			</div>		
			<div class="division"></div>
					
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
		
<div class="clear"></div>
</form>
		</div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Qualification Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>";

data_header[1] = new Array;
data_header[1][0] = "Qualification Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>";

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
Iterator itr=searchQualificationMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrMasQualification  hrMasQualification = (HrMasQualification)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasQualification.getId()%>
data_arr[<%= counter%>][1] = "<%= hrMasQualification.getQualificationCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasQualification.getQualificationName()%>"
data_arr[<%= counter%>][3] = "<%= hrMasQualification.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasQualification.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= hrMasQualification.getLastChgTime() %>" 
<% if(hrMasQualification.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "qualification"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	