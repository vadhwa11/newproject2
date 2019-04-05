<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_other_income_code.jsp  
 * Purpose of the JSP -  This is for Other Income Code.
 * @author  Vishal
 * Create Date: 29th Aug,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrMasItaxIncomeCode" %>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchOtherIncomeCodeList = (ArrayList)map.get("searchOtherIncomeCodeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	 String message ="";
	if(map.get("message") != null){
		    message = (String)map.get("message");
		   //out.println(message);
		  }
%>
<%if(!message.equals("")){ %>
<h4><%=message %></h4>
<%}%>
<div class="titleBg"> 
<h2>Other Earning Code Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Other Earning Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioAuto"/>
	<label>Other Earning Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioAuto"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Other Income  Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'incomeTaxMaster?method=searchOtherIncomeCode')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','incomeTaxMaster?method=searchOtherIncomeCode','checkSearch')" tabindex=1  />

    <!-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','incomeTaxMaster?method=printOtherEarningIncomeCodeMaster');" accesskey="g" tabindex=1/> -->
</form>
</div>
</div>
<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>
<form name="ancher" method="post">
</form>

	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
	   
		if(searchOtherIncomeCodeList.size()>0)
		 {	String strForCode = (String)map.get("otherIncomeCode");
			String strForCodeDescription = (String)map.get("otherIncomeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <!-- <a href="incomeTaxMaster?method=showOtherIncomeCodeJsp">Show All Records</a> -->
    <a href="javascript:void(0)" onclick="submitForm('ancher','incomeTaxMaster?method=showOtherIncomeCodeJsp');">Show All Records</a>
    
	<%
			}
		 }
	if(searchOtherIncomeCodeList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<!-- <a href="incomeTaxMaster?method=showOtherIncomeCodeJsp">Show All Records</a> -->
				<a href="javascript:void(0)" onclick="submitForm('ancher','incomeTaxMaster?method=showOtherIncomeCodeJsp');">Show All Records</a>
				

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
<form name="otherIncomeCode" method="post" action="">
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "HrMasItaxIncomeCode">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="IncomeDesc">
  	<input type="hidden" name="title" value = "OtherIncomeCode">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "hr_other_income_code">
  	<input type="hidden" name="pojoPropertyCode" value = "IncomeCode">
<div class="division"></div>
	<label>Other Earning Code <span>*</span> </label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Other Income Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label>Other Earning Code Name <span>*</span></label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Other Income Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'incomeTaxMaster?method=addOtherIncomeCode')" >

<script>
	document.otherIncomeCode.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
			
 
	
<div class="division"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('otherIncomeCode','incomeTaxMaster?method=addOtherIncomeCode');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('otherIncomeCode','incomeTaxMaster?method=editOtherIncomeCode')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" style="display: none;" value="Activate" class="button" onClick="submitForm('otherIncomeCode','incomeTaxMaster?method=deleteOtherIncomeCode&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
	
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
data_header[0][0] = "Other Income Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Other Income Name"
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
Iterator itr=searchOtherIncomeCodeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrMasItaxIncomeCode  hrMasItaxIncomeCode = (HrMasItaxIncomeCode)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasItaxIncomeCode.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasItaxIncomeCode.getIncomeCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasItaxIncomeCode.getIncomeDesc()%>"

data_arr[<%= counter%>][3] = "<%= hrMasItaxIncomeCode.getLastChgBy() %>"

data_arr[<%= counter%>][4] = "<%= hrMasItaxIncomeCode.getLastChgDate() %>"
data_arr[<%= counter%>][5] = "<%= hrMasItaxIncomeCode.getLastChgTime()%>"

<% if(hrMasItaxIncomeCode.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "otherIncomeCode"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  