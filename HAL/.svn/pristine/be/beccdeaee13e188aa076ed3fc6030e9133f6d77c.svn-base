<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * block.jsp  
 * Purpose of the JSP -  This is for Block Details.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 21st Feb, 2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasBlock> masBlockList = new ArrayList<MasBlock>();
	List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
	List<MasBlock> gridBlockList = new ArrayList<MasBlock>();
	
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masBlockList") != null){
		masBlockList = (ArrayList)map.get("masBlockList");
	}
	if(map.get("masDistrictList") != null){
		masDistrictList = (ArrayList)map.get("masDistrictList");
	}
	if(map.get("gridBlockList") != null){
		gridBlockList = (ArrayList)map.get("gridBlockList");
	}
	
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		
		System.out.println("ex");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
<%}%>
<div class="titleBg">
<h2>Block Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Block Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Block Description</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Block Code,string,no"	MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchBlock')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchBlock','checkSearch')"	tabindex=1 />
<%--- Report Button   --%>


<input type="hidden" name="colCode" value="block_code">
<input type="hidden" name="colName" value="block_name">

<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_block">
</div>
</form>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div><% 
		if(masDistrictList.size()>0 && masBlockList.size() > 0)
		 {
			String strForCode = (String)map.get("blockCode");
			String strForCodeDescription = (String)map.get("blockName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
<h4><a href="generalMaster?method=showBlockJsp">Show All Records </a> </h4> <%
			}
		 }
	 if(masDistrictList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="generalMaster?method=showBlockJsp">Show All Records</a> </h4> <%
     }
	%> 
<script type="text/javascript">	
formFields = [[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DISTRICT_ID%>"], [4,"<%=CHANGED_BY%>"], [5,"<%=CHANGED_DATE%>"],[6,"<%=CHANGED_TIME%>"],[7,"<%=STATUS%>"] ];
		 statusTd = 7;
	</script>
</div>
<div class="Clear paddingTop15"></div>
<form name="block" method="post" action="">
<input type="hidden"	name="<%= POJO_NAME %>" value="MasBlock"> 
<input type="hidden"	name="<%=POJO_PROPERTY_NAME %>" value="BlockName"> 
<input	type="hidden" name="title" value="block"> 
<input type="hidden"	name="<%=JSP_NAME %>" value="block"> 
<input type="hidden"	name="pojoPropertyCode" value="blockCode"> 
<div class="Clear"></div>
<div class="Block">
<label > Block Code <span>*</span></label>
<input id="codeId" type="text"	name="<%= CODE%>" value="" validate="Block Code,string,yes"  MAXLENGTH="8" tabindex=1 /> <label
	> Block Name <span>*</span></label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Block  Name,string,yes"  MAXLENGTH="30"
	tabindex=1 /> <script>
				document.block.<%=CODE%>.focus();
			</script> <label > District<span>*</span></label><select name="<%= DISTRICT_ID%>" validate="District,string,yes"
	tabindex=1
	onkeypress="return submitenter(this,event,'generalMaster?method=addBlock')">
	<option value="">Select</option>
	<% 
				
				for (MasDistrict  masDistrict : masDistrictList){
				%>
	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getDistrictName()%></option>	<%}%>
</select> 
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('block','generalMaster?method=addBlock');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('block','generalMaster?method=editBlock')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	onClick="submitForm('block','generalMaster?method=deleteBlock&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" /> 
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
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div id="edited"></div>
</form>
</div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Block Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"
data_header[1] = new Array;
data_header[1][0] = "Block Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";
data_header[2] = new Array;
data_header[2][0] = "District"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISTRICT_ID %>";
data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY%>"
data_header[4] = new Array;
data_header[4][0] = "Admin"
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE%>"
data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_TIME%>";
data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";
data_arr = new Array();<%
Iterator itr=masBlockList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasBlock  masBlock = (MasBlock)itr.next(); 
%>data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masBlock.getId()%>
data_arr[<%= counter%>][1] = "<%=masBlock.getBlockCode()%>"
data_arr[<%= counter%>][2] = "<%= masBlock.getBlockName()%>"
<%
		Iterator itrGridDistrictList=gridBlockList.iterator();
		 while(itrGridDistrictList.hasNext())
            {
             MasDistrict  masDistrict = (MasDistrict)itrGridDistrictList.next(); 
            
			 if(masBlock.getDistrict().getId().equals(masDistrict.getId()) && masDistrict.getStatus().equals("y")){
			
			 %>
				data_arr[<%= counter%>][3] = "<%=masDistrict.getDistrictName()%>"
			<%}else if(masBlock.getDistrict().getId().equals(masDistrict.getId()) && masDistrict.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masDistrict.getDistrictName()%>";
				
			<%}
}%>data_arr[<%= counter%>][4] = "<%= masBlock.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masBlock.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masBlock.getLastChgTime() %>"<% if(masBlock.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "block"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
