<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * poDeliveryTerms.jsp  
 * Purpose of the JSP -  This is for PO Delivery Terms .
 * @author  Dipali
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasStorePoDeliveryTerms"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	ArrayList searchPoDeliveryList = (ArrayList)map.get("searchPoDeliveryTermsList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <label><span><%=message %></span></label>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Supply Order Delivery/Payment Terms</h2>
</div>
<div class="clear"></div>

   <div id="searcharea">
   
    <div id="searchbar">
    
     <form name="search" method="post" action="">
<div class="Block">       
			   		<label >So Type </label>
      <input type="text" id="searchField"  name="<%= SEARCH_NAME%>" value=""  validate="SO Type,alphanumeric,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'pharmacy?method=searchPoDeliveryTerms')" />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchPoDeliveryTerms','checkSearch')" tabindex=1  />
                   		            <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_supply_order_delivery_payment">
        </div>            
       </form>
<div class="clear"></div>
</div>
   </div>

      
	<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
	<div id="searchresults" >
	<div id="searchtable" ></div>
	
 <% 
  if(searchPoDeliveryList.size()>0)
   {
   String strForCode = (String)map.get("poDeliveryTerms");
   if(strForCode!= null && strForCode!= "")
   {
 %> 
  

    <h4> <a  href="pharmacy?method=showPoDeliveryTermsJsp">Show All Records</a></h4>
	<%
			}
		 }
	if(searchPoDeliveryList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a  href="pharmacy?method=showPoDeliveryTermsJsp">Show All Records</a></h4>

	 <%
  }
	%>
	
 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"<%= DESCRIPTION %>"], [3,"<%= CHANGED_BY %>"], [4," <%= CHANGED_DATE %> "],[5," <%= CHANGED_TIME %> "],[6,"<%=STATUS%>"] ];
  statusTd = 6;
 </script>
 </div>
 
  <form name="poDeliveryTerms" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasStorePoDeliveryTerms">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PoDeliveryTermsName">
  <input type="hidden" name="title" value = "PoDeliveryTerms">
  <input type="hidden" name="<%=JSP_NAME %>" value = "poDeliveryTerms">

     <div class="clear"></div>
     <div class="clear"></div>
  <div class="Block">

     	<label class="medium"> SO Type <span>*</span></label>
			 <select name="<%=SEARCH_NAME%>"  validate="SO Type,alphanumeric,yes">
			  <option value="0">Select</option>
			  <option value="Delivery">Delivery</option>
			    <option value="Payment">Payment</option>
			 </select>
			 <label class="auto"> Description <span>*</span></label>
		<input type="text" name="<%=DESCRIPTION%>" value="" validate="Description,alphanumeric,yes"  style="width:520px;" MAXLENGTH="100" onkeypress="return submitenter(this,event,'pharmacy?method=addPoDeliveryTerms')"/>

</form>
</div>
<div class="clear"></div>
<div class="division"></div>
		<div id="edited"></div>
<div class="clear"></div>
   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('poDeliveryTerms','pharmacy?method=addPoDeliveryTerms');" accesskey="a" tabindex=1/>
   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('poDeliveryTerms','pharmacy?method=editPoDeliveryTerms')" accesskey="u" tabindex=1 />
   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('poDeliveryTerms','pharmacy?method=deletePoDeliveryTerms&flag='+this.value)" accesskey="d" tabindex=1/>  
   <input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
   <input type="hidden" name="<%=STATUS %>" value="" />
   <input type="hidden" name="<%= COMMON_ID%>" value="" />
   
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom">
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
				<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
<label>Changed By </label>   
<label class="value"><%=userName%></label>
<label>Changed Date </label>   
<label class="value"><%=date%></label> 
<label>Changed Time </label>   
<label class="value"><%=time%></label>

</div> 
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "SO Type"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Description"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= DESCRIPTION%>"
data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchPoDeliveryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasStorePoDeliveryTerms  masStorePoDeliveryTerms = (MasStorePoDeliveryTerms)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masStorePoDeliveryTerms.getId()%>
data_arr[<%= counter%>][1] = "<%= masStorePoDeliveryTerms.getPoDeliveryTermsName()%>"
data_arr[<%= counter%>][2] = "<%= masStorePoDeliveryTerms.getPoDeliveryTermsDescription()%>"
data_arr[<%= counter%>][3] = "<%= masStorePoDeliveryTerms.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masStorePoDeliveryTerms.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masStorePoDeliveryTerms.getLastChgTime() %>"
<% if(masStorePoDeliveryTerms.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
formName = "poDeliveryTerms"
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');  
</script>