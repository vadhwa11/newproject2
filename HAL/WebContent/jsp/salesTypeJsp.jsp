<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * salesTypeJsp.jsp  
 * Purpose of the JSP -  This is for Sales Type.
 * @author  Mansi
 * @author  Dipai
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.10
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasSalesType"%>

<%
		Map map = new HashMap();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		
		ArrayList searchSalesTypeList = (ArrayList)map.get("searchSalesTypeList");
			
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
%>

<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><span><%=message %></span></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Sales type</h2>
</div>
<div class="clear"></div>

 <div id="searcharea">
		 <form name="search" method="post" action="">
		 <div class="Block">
			    <label>Sales Type Code </label>
			    	<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
					<label class="auto">Sales Type Description </label>	
					<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />
									 
					 <input type="text"  id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Sales Type Code,alphanumeric,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchSalesType')" />
                    <input type="submit" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchSalesType','checkSearch')" tabindex=1  />
		            <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_sales_type">
		     </div>
		     </form>
			 <div class="clear"></div>
		 </div>		
 	 
	<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
   <div id="searchresults" tabindex=2 >
   <div id="searchtable" tabindex=2 ></div>
 
 <% 
  if(searchSalesTypeList.size()>0)
   {
   String strForCode = (String)map.get("salesTypeCode");
   String strForCodeDescription = (String)map.get("salesTypeName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
  

     <h4><a  href="pharmacy?method=showSalesTypeJsp">Show All Records</a></h4>
	<%
			}
		 }
	if(searchSalesTypeList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a  href="pharmacy?method=showSalesTypeJsp">Show All Records</a></h4>

	 <%
  }
	%>
 <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= SALES_TYPE_VALUE %>"], [4,"<%=CHANGED_BY%>"], [5,"<%=CHANGED_DATE%>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script>
	</div>
	
  <form name="salesType" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasSalesType">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "SalesTypeName">
  <input type="hidden" name="<%=JSP_NAME %>" value = "salesTypeJsp">
  <input type="hidden" name="pojoPropertyCode" value = "SalesTypeCode">
<div class="clear"></div>
<div class="clear"></div>	  	
<div class="clear"></div>	
 	<div class="Block">
	  	<label> SalesType <span>*</span></label>
		<input id="codeId" type="text" name="<%= CODE%>" value="" validate="SalesType,alphanumeric,yes"  MAXLENGTH="8"/ tabindex=1 >
  		<label class="auto">  Sales Type Description <span>*</span></label>
			<input type="text" name="<%= SEARCH_NAME %>" value="" validate="SalesType Description,alphanumeric,yes"  MAXLENGTH="30"/ tabindex=1 >
			<label class="auto"> Sales Type Value <span>*</span></label>
			<input type="text" name="<%= SALES_TYPE_VALUE %>" value="" validate="SalesType Value,int,yes"  MAXLENGTH="30"/ tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=addSalesType')">
			</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('salesType','pharmacy?method=addSalesType');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('salesType','pharmacy?method=editSalesType')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('salesType','pharmacy?method=deleteSalesType&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By </label>   
			<label class="value"><%=userName%></label>
			<label>Changed Date </label>   
			<label class="value"><%=date%></label>
			<label>Changed Time </label>   
			<label class="value"><%=time%></label>
					
   </div>	

			</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "SalesType Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "SalesType Description"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "SalesType Value"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=SALES_TYPE_VALUE %>";
	
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
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";


data_arr = new Array();

<%

Iterator itr=searchSalesTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasSalesType  masSalesType = (MasSalesType)itr.next(); %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSalesType.getId()%>
data_arr[<%= counter%>][1] = "<%=masSalesType.getSalesTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masSalesType.getSalesTypeName()%>"
data_arr[<%= counter%>][3]="<%= masSalesType.getSalesTypeValue()%>"
data_arr[<%= counter%>][4] = "<%= masSalesType.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masSalesType.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masSalesType.getLastChgTime() %>"
<% if(masSalesType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
       counter++;
}
%>
formName = "salesType"

nonEditable = ['<%=CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  