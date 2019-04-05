<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.15  
--%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<script type="text/javascript" language="javascript"	src="/erp/jsp/js/ajax.js"></script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<FaMasAccountGroup> districtList = new ArrayList<FaMasAccountGroup>();
	districtList = (ArrayList)map.get("gridMasAccountGroupList");
	
	ArrayList searchBlockList = (ArrayList)map.get("faMasAccountSubGroupList");
	ArrayList gridDistrictList = (ArrayList)map.get("gridMasAccountGroupList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println("<h4>"+message+"</h4>");
		  }
	
	String accountGroupName="";

	if(map.get("accountGroupName") != null){
		accountGroupName = (String)map.get("accountGroupName");
		  
		  }
 %>
<div class="titleBg">
<h2>Account Sub Group Master</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">

<label class="auto">Account Sub Group Code</label> 
<input type="radio"	class="radioAuto" name="<%=SELECTED_RADIO  %>" value="1"  checked="checked" /> 

<label class="auto">Account Sub Group Name</label> 
<input type="radio"	class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  checked="checked" style="margin-right:76px;"/>

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Account Sub Group Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'masters?method=searchBlock')" />

<input type="hidden" name="colCode" value="block_code">
<input type="hidden" name="colName" value="block_name">

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','account?method=searchAccountSubGroup','checkSearch')"	tabindex=1 />

 <%--- Report Button  
<input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','masters?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_block">
 --%> 

	<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('search','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc_sub_group"/>
</div>
</form>
</div>
</div>

<form name="ancher" method="post">
</form>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% System.out.println("accountGroupName==============>"+accountGroupName);
	if(searchBlockList != null && accountGroupName!=null && !accountGroupName.equals(""))
	{%>
		<!--  <h4><a href="account?method=showAccountSubGroup">Show All Records</a></h4> -->
		<h4><a href="javascript:void(0)" onclick="submitForm('ancher','account?method=showAccountSubGroup');">Show All Records</a></h4>
<% } else { %>
		<%-- <h4><a href="account?method=showAccountSubGroup">Show All Records</a></h4> --%>
		 <%} %>
 <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DISTRICT_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>
<form name="block" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasBlock"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BlockName">
<input type="hidden" name="title" value="Block"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="block"> 
<input	type="hidden" name="pojoPropertyCode" value="BlockCode"> 
<div class="Block">
<label> Account Sub Group Code <span>*</span></label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Account Sub Group Code,int,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1> 
<label> Account Sub Group Name<span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Account Sub Group Name,string,yes" class="textbox_size20"	MAXLENGTH="200"  tabindex=1> 
<script>
				document.block.<%=CODE%>.focus();
			</script> 
<label> Account Group Name <span>*</span></label>
<select name="<%= DISTRICT_ID %>" validate="Account Group Name ,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'masters?method=addCountry')">
<option value="0">Select</option>
	<% 
	for (FaMasAccountGroup  masDistrict : districtList){
				%>
	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getAccountGroupDesc()%></option>
	<%}%>
</select>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button" onClick="submitForm('block','account?method=addAccountSubGroupNew');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none" class="button" onClick="submitForm('block','account?method=updateAccountSubGroupNew')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none" class="button"	onClick="submitForm('block','account?method=deleteAccountSubGroupNew&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('search','account?method=showAccountSubGroup')" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
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
</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Account Sub Group Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Account Sub Group Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Account Group Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISTRICT_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
if(searchBlockList != null)
{
Iterator itr=searchBlockList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             FaMasAccountSubGroup  masBlock = (FaMasAccountSubGroup)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masBlock.getId()%>
data_arr[<%= counter%>][1] = "<%=masBlock.getAccountSubGroupCode()%>"
	data_arr[<%= counter%>][2] = "<%= masBlock.getAccountSubGroupName()%>"

<%
		Iterator itrGridDistrictList=gridDistrictList.iterator();
		 while(itrGridDistrictList.hasNext())
            {
			 try{
             FaMasAccountGroup  districtGrid = (FaMasAccountGroup)itrGridDistrictList.next(); 
			 if(masBlock.getAccountGroup().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=districtGrid.getAccountGroupDesc()%>"
			<%}else if(masBlock.getAccountGroup().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid.getAccountGroupDesc()%>";
				
			<%}
            }catch(Exception e){}}%>

            data_arr[<%= counter%>][4] = "<%= masBlock.getLastChgBy()!=null?(masBlock.getLastChgBy().getId()!=null?masBlock.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masBlock.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masBlock.getLastChgTime() %>"
<% if(masBlock.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
          }
%>
formName = "block"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
