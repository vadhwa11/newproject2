<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * diagnosisConclusion.jsp  
 * Purpose of the JSP -  This is for Diagnosis Conclusion
 * @author  Dipali
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:
 * @version 1.13  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchDiagnosisConclusionList = (ArrayList)map.get("searchDiagnosisConclusionList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}	
%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><%=message %></h4> <% 
	  }
%>
<div class="titleBg"><h2>Diagnosis Conclusion</h2></div>
<div class="Clear"></div>
	  <div id="searcharea">	  
		  <div id="searchbar">		  
			  <form name="search" method="post" action="">
			    <div class="Block">
			    <label>DC Code</label>
			    	<input type="radio" name="<%=SELECTED_RADIO  %>" class="radioAuto"  value="1" checked="checked" />
					<label>DC Name</label>
					<input type="radio" name="<%=SELECTED_RADIO %>" class="radioAuto" value="2"  />					
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="DC Code,string,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'laboratory?method=searchDiagnosisConclusion')" />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchDiagnosisConclusion','checkSearch')" tabindex=1  />
					<%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig2" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_diagnosis_conclusion">
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
		if(searchDiagnosisConclusionList.size()>0)
		 {
			String strForCode = (String)map.get("diagnosisConclusionCode");
			String strForCodeDescription = (String)map.get("diagnosisConclusionName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
    
    <h4><a href="laboratory?method=showDiagnosisConclusionJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchDiagnosisConclusionList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="laboratory?method=showDiagnosisConclusionJsp">Show All Records</a></h4>

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
  <form name="diagnosisConclusion" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasDiagnosisConclusion">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DiagnosisConclusionName">
  <input type="hidden" name="title" value = "DiagnosisConclusion">
  <input type="hidden" name="<%=JSP_NAME %>" value = "diagnosisConclusion">
  <input type="hidden" name="pojoPropertyCode" value = "DiagnosisConclusionCode">
	  		
<div class="Block">
	  	<label >  DC Code <span>*</span></label>
		<input id="codeId" type="text" name="<%= CODE%>" value="" validate="DC Code,string,yes"  MAXLENGTH="8" tabindex=1 >
  		<label >DC Name <span>*</span></label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="DC Name,string,yes"  MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'laboratory?method=addDiagnosisConclusion')">
			<script>
				document.diagnosisConclusion.<%=CODE%>.focus();
			</script>			
			</div>
			
			<div class="Clear"></div>
			<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('diagnosisConclusion','laboratory?method=addDiagnosisConclusion');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('diagnosisConclusion','laboratory?method=editDiagnosisConclusion')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('diagnosisConclusion','laboratory?method=deleteDiagnosisConclusion&flag='+this.value)" accesskey="d" tabindex=1/>		
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
	   </div>	
			</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "DC Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "DC Name"
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
Iterator itr=searchDiagnosisConclusionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasDiagnosisConclusion  masDiagnosisConclusion = (MasDiagnosisConclusion)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masDiagnosisConclusion.getId()%>
data_arr[<%= counter%>][1] = "<%=masDiagnosisConclusion.getDiagnosisConclusionCode()%>"
data_arr[<%= counter%>][2] = "<%= masDiagnosisConclusion.getDiagnosisConclusionName()%>"
data_arr[<%= counter%>][3] = "<%= masDiagnosisConclusion.getLastChgby() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masDiagnosisConclusion.getLastchgdate()) %>"
data_arr[<%= counter%>][5] = "<%= masDiagnosisConclusion.getLastchgtime() %>"
<% if(masDiagnosisConclusion.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "diagnosisConclusion"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  