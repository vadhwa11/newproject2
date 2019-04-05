<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * sample.jsp  
 * Purpose of the JSP -  This is for sample.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.11
--%>


<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="jkt.hms.masters.business.DgUom"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchSampleList = (ArrayList)map.get("searchSampleList");
	List<DgMasCollection> searchCollectionList = new ArrayList<DgMasCollection>();
	List<DgUom> searchInvestigationUomList = new ArrayList<DgUom>();
	if(map.get("searchCollectionList") != null){
		searchCollectionList = (ArrayList)map.get("searchCollectionList");
		}
	if(map.get("searchInvestigationUomList") != null){
		searchInvestigationUomList = (ArrayList)map.get("searchInvestigationUomList");
		}
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

<div class="titleBg"><h2>Sample Master</h2></div>
<div class="Clear"></div>
	  <div id="searcharea">	  
		  <div id="searchbar">		  
			  <form name="search" method="post" action="">
			    <div class="Block">
			    <label>Sample Code</label>
			    	<input type="radio"  class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
					<label>Sample Name</label>
					<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />					
					 <input type="text" id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Sample Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'laboratory?method=searchSample')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchSample','checkSearch')" tabindex=1  />
<%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig2" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_sample">
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
		if(searchSampleList.size()>0)
		 {
			String strForCode = (String)map.get("sampleCode");
			String strForCodeDescription = (String)map.get("sampleName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	  
    <h4><a href="laboratory?method=showSampleJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchSampleList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="laboratory?method=showSampleJsp">Show All Records</a></h4>

	 <%
     }
	%>


	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= SAMPLE_COLLECTION_ID%>"],[4,"<%= DG_UOM_ID%>"], [5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"]  ];
	 statusTd = 8;
	</script>
	</div>
	<div class="Clear"></div>
  <form name="sample" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasSample">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SampleDescription">
  <input type="hidden" name="title" value = "Sample">
  <input type="hidden" name="<%=JSP_NAME %>" value = "sample">
  <input type="hidden" name="pojoPropertyCode" value = "SampleCode">	  		
	  		
 	<div class="Block">
	  	<label > Sample Code <span>*</span> </label>
		<input type="text" name="<%= CODE%>" value="" validate="Sample Code,string,yes"  MAXLENGTH="8" tabindex=1 />
		<label >Sample Name <span>*</span> </label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Sample Name,string,yes"  MAXLENGTH="30" tabindex=1 />
			<script>
				document.sample.<%=CODE%>.focus();
			</script>

		<label >Collection <span>*</span> </label>
  
	   <select name="<%= SAMPLE_COLLECTION_ID%>" validate="Collection,string,yes"  tabindex=1 " >
	   <option value="">Select</option>
	     <% 
	   		 for (DgMasCollection  dgMasCollection : searchCollectionList){
	    %>
	     <option value="<%=dgMasCollection.getId ()%>"><%=dgMasCollection.getCollectionName()%></option>
	         
	     <%}%>
	   </select>
	<div class="Clear"></div>
	   <label > UOM <span>*</span></label>
  
	   <select name="<%= DG_UOM_ID%>" validate="UOM,string,yes"  tabindex=1 onkeypress="return submitenter(this,event,'laboratory?method=addSample')">
	   <option value="">Select</option>
	     <% 
	   		 for (DgUom  dgUom : searchInvestigationUomList){
	    %>
	     <option value="<%=dgUom.getId ()%>"><%=dgUom.getUomName()%></option>
	         
	     <%}%>
	   </select>
			
			</div>
			<div class="Clear"></div>
			<div class="division"></div>
			<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('sample','laboratory?method=addSample');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('sample','laboratory?method=editSample')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('sample','laboratory?method=deleteSample&flag='+this.value)" accesskey="d" tabindex=1/>		
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
data_header[0][0] = "Sample Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Sample Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Collection"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=SAMPLE_COLLECTION_ID %>";

data_header[3] = new Array;
data_header[3][0] = "UOM"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=DG_UOM_ID %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";
data_arr = new Array();

<%

Iterator itr=searchSampleList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasSample  masSample = (MasSample)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSample.getId()%>
data_arr[<%= counter%>][1] = "<%=masSample.getSampleCode()%>"
data_arr[<%= counter%>][2] = "<%= masSample.getSampleDescription()%>"
<% if(masSample.getCollection() != null){%>
<%
		for(DgMasCollection dgMasCollection : searchCollectionList){
            if(masSample.getCollection() != null){
			if(masSample.getCollection().getId().equals(dgMasCollection.getId()) && dgMasCollection.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][3] = "<%=dgMasCollection.getCollectionName()%>"
			<%}else if(masSample.getCollection().getId().equals(dgMasCollection.getId()) && dgMasCollection.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=dgMasCollection.getCollectionName()%>";
				
			<%}
            }
		}
}%>
<% if(masSample.getUom() != null){%>
<%
		for(DgUom dgUom : searchInvestigationUomList){
            if(masSample.getUom() != null){
			if(masSample.getUom().getId().equals(dgUom.getId()) && dgUom.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][4] = "<%=dgUom.getUomName()%>"
			<%}else if(masSample.getUom().getId().equals(dgUom.getId()) && dgUom.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=dgUom.getUomName()%>";
				
			<%}
            }
		}
}%>
data_arr[<%= counter%>][5] = "<%= masSample.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masSample.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masSample.getLastChgTime() %>"
<% if(masSample.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "sample"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  