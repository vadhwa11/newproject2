<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_surcharge.jsp  
 * Purpose of the JSP -  This is for Surcharge.
 * @author  Vishal
 * Create Date: 28th Aug,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrMasSurcharge" %>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchSurchargeList = (ArrayList)map.get("searchSurchargeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	 String message ="";
	if(map.get("message") != null){
		    message = (String)map.get("message");
		  // out.println(message);
		  }
%>


<%if(!message.equals("")){ %>
	<h4><%=message%></h4>
<%} %>
<div class="titleBg"> 
<h2>Surcharge Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Surcharge Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioAuto"/>
	<label>Surcharge Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioAuto"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Surcharge  Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'incomeTaxMaster?method=searchSurcharge')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','incomeTaxMaster?method=searchSurcharge','checkSearch')" tabindex=1  />
    <!-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','incomeTaxMaster?method=printSurchargeMast');" accesskey="g" tabindex=1/> -->
</form>
</div>
</div>
<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>

	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<form name="ancher" method="post">
</form>
	
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
	   // System.out.println("searchTaskTypeList  in controller  -- "+searchTaskTypeList.size());
		if(searchSurchargeList.size()>0)
		 {	String strForCode = (String)map.get("surchargeCode");
			String strForCodeDescription = (String)map.get("surchargeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <!-- <a href="incomeTaxMaster?method=showSurchargeJsp">Show All Records</a> -->
    <a href="javascript:void(0)" onclick="submitForm('ancher','incomeTaxMaster?method=showSurchargeJsp');">Show All Records</a>
    
	<%
			}
		 }
	if(searchSurchargeList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<!-- <a href="incomeTaxMaster?method=showSurchargeJsp">Show All Records</a> -->
<a href="javascript:void(0)" onclick="submitForm('ancher','incomeTaxMaster?method=showSurchargeJsp');">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="surcharge" method="post" action="">
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "HrMasSurcharge">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SurchargeDescription">
  	<input type="hidden" name="title" value = "Surcharge">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "hr_surcharge">
  	<input type="hidden" name="pojoPropertyCode" value = "SurchargeCode">
<div class="division"></div>
	<label>Surcharge Code <span>*</span> </label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Surcharge Code,string,yes" MAXLENGTH="8" tabindex=1 >
  	<label>Surcharge Name <span>*</span></label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Surcharge Name,string,yes" MAXLENGTH="50" tabindex=1 onkeypress="return submitenter(this,event,'incomeTaxMaster?method=addSurcharge')" >

<script>
	document.surcharge.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
	
<div class="clear"></div><div class="clear"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add"  onClick="submitForm('surcharge','incomeTaxMaster?method=addSurcharge');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update"  style="display: none;" onClick="submitForm('surcharge','incomeTaxMaster?method=editSurcharge')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" style="display: none;" value="Activate"  onClick="submitForm('surcharge','incomeTaxMaster?method=deleteSurcharge&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
	
	<div class="clear"></div>

	<%-- <label>Changed By:</label>   
	<label class="value"><%=userName%></label>
			        
	<label>Changed Date:</label>   
	<label class="value"><%=date%></label>
			 
	<label>Changed Time:</label>   
	<label class="value"><%=time%></label> --%>
			 
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
	<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Surcharge Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Surcharge Name"
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
Iterator itr=searchSurchargeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrMasSurcharge  hrMasSurcharge = (HrMasSurcharge)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasSurcharge.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasSurcharge.getSurchargeCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasSurcharge.getSurchargeDescription()%>"

data_arr[<%= counter%>][3] = "<%= hrMasSurcharge.getLastChgBy() %>"

data_arr[<%= counter%>][4] = "<%= hrMasSurcharge.getLastChgDate() %>"
data_arr[<%= counter%>][5] = "<%= hrMasSurcharge.getLastChgTime()%>"

<% if(hrMasSurcharge.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "surcharge"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  