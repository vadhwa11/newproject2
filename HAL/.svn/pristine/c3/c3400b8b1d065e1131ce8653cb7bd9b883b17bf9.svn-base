<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * postCode.jsp  
 * Purpose of the JSP -  This is for Post Code.
 * @author  Mansi
 * @author  Dipali
 * Create Date: 70th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasPostCode> masPostCodeList = new ArrayList<MasPostCode>();
		List<MasBlock> masBlockList = new ArrayList<MasBlock>();
		List<MasPostCode> gridPostCodeList = new ArrayList<MasPostCode>();
		
		String userName = "";
		if(request.getAttribute("map") != null){
		 map = (Map) request.getAttribute("map");
		}
		if(map.get("masPostCodeList") != null){
		 masPostCodeList = (ArrayList)map.get("masPostCodeList");
		}
		if(map.get("masBlockList") != null){
		 masBlockList = (ArrayList)map.get("masBlockList");
		}
		if(map.get("gridPostCodeList") != null){
		 gridPostCodeList = (ArrayList)map.get("gridPostCodeList");
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
<h2>Post Code Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label class="noWidth">PostCode</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label class="noWidth">PostCode Description</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="PostCode,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchPostCode')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchPostCode','checkSearch')" tabindex=1 />
<%--- Report Button   --%>



<input type="hidden" name="colCode" value="post_code">
<input type="hidden" name="colName" value="post_code_name">




<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />

<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_post_code">
</div>
</form>
</div>
</div>
<div class="Clear"></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div><% 
  if(masBlockList.size()>0 && masPostCodeList.size() > 0)
   {
   String strForCode = (String)map.get("postCode");
   String strForCodeDescription = (String)map.get("postCodeName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
<h4><a href="generalMaster?method=showPostCodeJsp">Show All Records </a> </h4> <%
   }
   } 
 if(masBlockList.size()==0 && map.get("search") != null)
 {
%> <h4><a href="generalMaster?method=showPostCodeJsp">Show All Records</a> </h4> <%
 }
%> <script type="text/javascript"> formFields = [
     [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= BLOCK_ID%>"],  [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
  statusTd = 7;
</script>
</div>
<div class="Clear paddingTop15"></div>
<form name="postCode" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasPostCode"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PostCodeName">
<input type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="PostCode">
<input type="hidden" name="title" value="MasBlock"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="<%=POSTCODE_JSP%>">
<input type="hidden" name="pojoPropertyCode" value="MasPostCode">
<div class="Clear"></div>
<div class="Block">
<label> Post Code <span>*</span></label> 
<input id="codeId" type="text"	name="<%= CODE%>" value="" validate="PostCode,string,yes"	 MAXLENGTH="8" tabindex=1 /> 
<label>Post Code Name <span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="PostCode Name,string,yes"	MAXLENGTH="30" tabindex=1 /> 
<script>
    document.postCode.<%=CODE%>.focus();
   </script> 
<label >Block <span>*</span> </label>
<select name="<%= BLOCK_ID%>" validate="Block,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addPostCode')">
	<option value="">Select</option>
	<% 
	   		 for (MasBlock  masBlock : masBlockList){
	    %>
	<option value="<%=masBlock.getId ()%>"><%=masBlock.getBlockName()%></option>	<%}%>
</select> 
</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('postCode','generalMaster?method=addPostCode');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('postCode','generalMaster?method=editPostCode')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('postCode','generalMaster?method=deletePostCode&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
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

	</form>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "PostCode"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"
data_header[1] = new Array;
data_header[1][0] = "PostCode Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= SEARCH_NAME %>";
data_header[2] = new Array;
data_header[2][0] = "Block"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=BLOCK_ID %>";
data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"
data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"
data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%=CHANGED_TIME %>";
data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";
data_arr = new Array();<%
Iterator itr=masPostCodeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasPostCode  masPostCode = (MasPostCode)itr.next(); 
%>data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masPostCode.getId()%>
data_arr[<%= counter%>][1] = "<%=masPostCode.getPostCode()%>"
data_arr[<%= counter%>][2] = "<%= masPostCode.getPostCodeName()%>"
<%
  Iterator itrGridBlockList=gridPostCodeList.iterator();
   while(itrGridBlockList.hasNext())
            {
             MasBlock  masBlock = (MasBlock)itrGridBlockList.next(); 
            
    if(masPostCode.getBlock().getId().equals(masBlock.getId()) && masBlock.getStatus().equals("y")){
   
    %>
    data_arr[<%= counter%>][3] = "<%=masBlock.getBlockName()%>"
   <%}else if(masPostCode.getBlock().getId().equals(masBlock.getId()) && masBlock.getStatus().equals("n")){%>
    data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masBlock.getBlockName()%>";
    
   <%}
}%>data_arr[<%= counter%>][4] = "<%= masPostCode.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masPostCode.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masPostCode.getLastChgTime() %>"
<% if(masPostCode.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "postCode"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);intializeHover('searchresulttable', 'TR', ' tableover');  
</script>