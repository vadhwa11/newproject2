<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemCategory.jsp  
 * Purpose of the JSP -  This is for Item Category.
 * @author  shailesh
 * @author  shailesh
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>



<% String message ="";
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchPatientFamilyHistoryList = (ArrayList)map.get("searchPatientFamilyHistoryList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		    message = (String)map.get("message");
		  
		  }	 	
	%>

<%@page import="jkt.hms.masters.business.PatientFamilyHistory"%><h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Family History Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">

<label class="auto"> Family History Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"  class="radioCheckCol1" /> 
<label class="auto"> Family History Description</label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheckCol1" /> 
<input	type="hidden" name="colCode" value="patient_family_history_code"/>
<input	type="hidden" name="colName" value="patient_family_history_name"/>

<input	type="hidden" name="templateCode" value="FH"/>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Sub Section Code,alphanumeric,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'opdMaster?method=searchItemCategory')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','opdMaster?method=searchFamilyHistory','checkSearch')" tabindex=1  />
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','hospital?method=generateReportForGeneralMastersPatientFamilyHistory');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_Family_History"/>
</form>
</div>
</div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
			if(searchPatientFamilyHistoryList.size()>0)
			 {
				String strForCode = (String)map.get("familyHistoryCode");
				String strForCodeDescription = (String)map.get("familyHistoryName");
				if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
				{
		%> 			
	  
	    <a href="opdMaster?method=showFamilyHistoryJsp">Show All Records</a>
		<%
				}
			 }
			 
		%>	 <script type="text/javascript">		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME%>"],  [3,"<%=CHANGED_BY%>"], [4,"<%=CHANGED_DATE%>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
		 statusTd = 6;

		</script></div>
<div class="clear">

</div>
 <form name="familyHistory" method="post" action="">

	  <input type="hidden" name="<%= POJO_NAME %>" value = "PatientFamilyHistory"/>
	  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "PatientHistoryName"/>
	  <input type="hidden" name="<%=JSP_NAME %>" value = "familyHistory"/>
	  <input type="hidden" name="pojoPropertyCode" value = "PatientHistoryCode"/>		
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">


<label class="auto"><span>*</span> Family History Code</label>
<input id="codeId"	type="text" name="<%= CODE%>" value=""	validate="Family History Code,string,yes" MAXLENGTH="8" tabindex=1 />

<label class="auto"><span>*</span> Family History Name</label> 
<input type="text" name="<%= SEARCH_NAME %>"	value="" validate="Family History Name,string,yes"		MAXLENGTH="30" tabindex=1 />

<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('familyHistory','opdMaster?method=addFamilyHistory');" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('familyHistory','opdMaster?method=editFamilyHistory')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('familyHistory','opdMaster?method=deleteFamilyHistory')" accesskey="d" tabindex=1/>		
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="checkReset();" accesskey="r" /> 
<input type="hidden"	name="<%=STATUS %>" value="" /> 
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>ChangedTime</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
</form>
<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Family History Code"
	data_header[0][1] = "data";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Family History Name"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= SEARCH_NAME %>";
	
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
	data_header[4][2] = 0;
	data_header[4][3] = "<%=CHANGED_TIME %>";

	data_header[5] = new Array;
	data_header[5][0] = "Status"
	data_header[5][1] = "data";
	data_header[5][2] = 0;
	data_header[5][3] = "<%=STATUS %>";
	
	
	data_arr = new Array();
	
	<%	
	Iterator itr=searchPatientFamilyHistoryList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {	            
	        	  PatientFamilyHistory  patientFamilyHistory = (PatientFamilyHistory)itr.next(); 
	%>	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= patientFamilyHistory.getId()%>
	data_arr[<%= counter%>][1] = "<%=patientFamilyHistory.getPatientHistoryCode()%>"
	data_arr[<%= counter%>][2] = "<%= patientFamilyHistory.getPatientHistoryName()%>"
		
		
	
	<%if(patientFamilyHistory.getLastChgBy() != null){%>
	data_arr[<%= counter%>][3] = "<%= patientFamilyHistory.getLastChgBy()!=null?(patientFamilyHistory.getLastChgBy().getId()!=null?patientFamilyHistory.getLastChgBy().getId():"0" ):"0"%>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>
<%if(patientFamilyHistory.getLastChgDate() != null){%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(patientFamilyHistory.getLastChgDate()) %>"
<%}%>
<%if(patientFamilyHistory.getLastChgTime() != null){%>
data_arr[<%= counter%>][5] = "<%= patientFamilyHistory.getLastChgTime() %>"
<%}%>
<% if(patientFamilyHistory.getStatus().equalsIgnoreCase("y") && patientFamilyHistory.getStatus()!= null){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
formName = "familyHistory"	
nonEditable = ['<%= CODE%>'];	
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>