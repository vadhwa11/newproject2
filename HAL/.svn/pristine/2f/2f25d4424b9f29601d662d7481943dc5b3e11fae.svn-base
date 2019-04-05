<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * allotmentOfFundsForMinorWorks.jsp  
 * Purpose of the JSP -  This is for Allotment of funds for minor work screen.
 * @author  Vineet Kumar
 * Create Date: 17th July,2009 
 * Revision Date:      
 * Revision By: 

--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page
	import="jkt.hms.masters.business.MasAllotmentOfFundsForMinorWorks"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript">

function beforeSave()
{
document.getElementById("refreshCheck").value = true;
return true;
}

function afterSave()
{
alert("Refresh check"+ document.getElementById("refreshCheck").value )
if(document.getElementById("refreshCheck").value)
{
document.getElementById("refreshCheck").value = false;
return true;
}
else
return false;
}


</script>
<SCRIPT>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
			
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	</script>
<script language="JavaScript" type="text/JavaScript"> 
function isNumber(field) { 
        var re = /^[0-9-'.'-',']*$/; 
        if (!re.test(field.value)) { 
            alert('please enter only numeric data'); 
            field.value = field.value.replace(/[^0-9-'.'-',']/g,""); 
        } 
    } 
    
    </script>
<SCRIPT>
	<%

		Calendar calendar1=Calendar.getInstance();
		String month1=String.valueOf((calendar1.get(Calendar.MONTH))+1);
		String dateCal1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar1.YEAR);
		if(month.length()<2){
			month1="0"+month1;
		}
		if(dateCal1.length()<2){
			dateCal1="0"+dateCal1;
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String userName="";
		if(session.getAttribute("userName")!=null)
		 userName=(String)session.getAttribute("userName");
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		//String Session=(String) utilMap.get("session");
		String time = (String) utilMap.get("currentTime");		
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
	
	</script>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1); 
%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date1 = (String)utilMap.get("currentDate");	 
	String time1 = (String)utilMap.get("currentTime");
	ArrayList searchAllotmentOfFundsList = (ArrayList)map.get("searchAllotmentOfFundsList");
	String sessionPeriod="";
	if(map.get("session")!=null)
	{
		sessionPeriod=(String) map.get("session");
	}
	String userName1 = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message ="";
	
	
	
%>

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>

<div class="Clear"></div>
<div id="contentHolder">
<h6>Allotment of Funds for minor works</h6>
<div class="Clear"></div>
<div class="header">
<form name="search" method="post" action=""><label>Allotment
File No.</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" /> <input type="text" id="searchField1"
	name="<%= SEARCH_FIELD%>" value="" MAXLENGTH="30" tabindex=1 /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','allotmentOfFunds?method=searchAllotmentOfFunds','checkSearchForSingleWorkService')"
	tabindex=1 /></form>


</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%       
    if(searchAllotmentOfFundsList != null && searchAllotmentOfFundsList.size()==0)
     {
    %>
<div class="Clear"></div>
<h5><a href="allotmentOfFunds?method=showAllotmentOfFundsJsp">Show
All Records</a></h5>
<div class="Clear"></div>
<%
     }
   %>
</div>

<div class="blockTitle">Allotment of Funds for minor works</div>
<div class="blockTitleCurve"></div>


<form name="allotmentOfFunds" method="post" action="">
<div class="blockFrame">



<div class=Clear></div>

<Label class="large"> <span>*</span> Financial Year </Label> <select
	name="<%=FINANCIAL_YEAR%>" validate="Financial year,string,yes"
	tabindex=1>
	<option value="<%=sessionPeriod%>"><%=sessionPeriod%></option>

</select> <label class="large"><span>*</span> Allotment File No </label> <input
	type="text" name="<%= ALLOTMENT_FILE_NO %>" value=""
	validate="Allotment File No,string,yes" MAXLENGTH="30" tabindex=1 /> <script>
				document.allotmentOfFunds.<%= FINANCIAL_YEAR %>.focus();
			</script>


<div class=Clear></div>
<label class="large"><span>*</span> Allotment File Date </label> <input
	type="text" name="<%= ALLOTMENT_FILE_DATE%>" value="" class="calDate"
	validate="Allotment File Date,date,yes" MAXLENGTH="12" tabindex=1 /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',allotmentOfFunds.<%=ALLOTMENT_FILE_DATE%>,event)" ; />
<label class="large"><span>*</span> Allotment Amount</label> <input
	type="text" name="<%= ALLOTMENT_AMOUNT %>" value="" class="medium"
	validate="Allotment Amount,float,yes" onkeyup="isNumber(this)"
	MAXLENGTH="12" / tabindex=1>
<div class=Clear></div>
<label class="large">Remarks</label> <textarea class="large"
	name="<%=ALLOTMENT_REMARKS %>" MAXLENGTH="12" tabindex=1></textarea></div>
<div class=Clear></div>

<div class=Clear></div>

<div class="division"></div>
<!--Bottom labels starts-->
<div id="edited"></div>

<script type="text/javascript">
   
   formFields = [[0, "<%= COMMON_ID%>", "id"], [1,"<%= FINANCIAL_YEAR%>"], [2,"<%= ALLOTMENT_FILE_NO %>"],[3,"<%= ALLOTMENT_FILE_DATE%>"], [4,"<%= ALLOTMENT_AMOUNT %>"], [5,"<%= ALLOTMENT_REMARKS%>"],[6,"<%=STATUS %>"]];
    statusTd =6;
   </script>

<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Save" class="button"
	onClick="submitForm('allotmentOfFunds','allotmentOfFunds?method=addAllotmentOfFunds','checkMaxValueForWorkCategory');"
	accesskey="a" tabindex="1" /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('allotmentOfFunds','allotmentOfFunds?method=editAllotmentOfFundsToDatabase','tValue')"
	accesskey="u" tabindex="1" /> <input type="button" name="back"
	id="back" value="Back" class="button"
	onclick="javascript:history.back()" accesskey="b" tabindex="1" /> <!--<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('allotmentOfFunds','allotmentOfFunds?method=deleteAllotmentOfFundsToDatabase&flag='+this.value)" accesskey="d" tabindex="1" />		
			--><input type="reset" name="Reset" id="reset" value="Reset"
	class="button" onclick="resetCheck();" accesskey="r" tabindex=1 />

<div class="division"></div>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
</div>


<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Financial Year"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= FINANCIAL_YEAR%>"

data_header[1] = new Array;
data_header[1][0] = "Allotment File No"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= ALLOTMENT_FILE_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Allotment File Date"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= ALLOTMENT_FILE_DATE %>";

data_header[3] = new Array;
data_header[3][0] = "Allotment Amount"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= ALLOTMENT_AMOUNT %>";

data_header[4] = new Array;
data_header[4][0] = "Remarks"
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=ALLOTMENT_REMARKS %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";
data_arr = new Array();
<%
   String finentialYear="";
   String allotmentFileNO = "";
   String allotmentDate = "";
	BigDecimal fileAmount = new BigDecimal(0);
	String remarks = "";
		
Iterator itr=searchAllotmentOfFundsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  
        	  MasAllotmentOfFundsForMinorWorks  masAllotmentOfFundsForMinorWorks = (MasAllotmentOfFundsForMinorWorks)itr.next(); 
        	if(masAllotmentOfFundsForMinorWorks.getFinancialYear()!= null)
        	{
        		finentialYear = masAllotmentOfFundsForMinorWorks.getFinancialYear();
        	}
        	else{
        		finentialYear="";
        	}
        	if(masAllotmentOfFundsForMinorWorks.getAllotmentFileNo() != null)
        	{
        		allotmentFileNO = masAllotmentOfFundsForMinorWorks.getAllotmentFileNo();
        	}else{
        		allotmentFileNO="";
        	}
        	if(masAllotmentOfFundsForMinorWorks.getAllotmentFileDate()!= null)
            {
        		allotmentDate = HMSUtil.convertDateToStringWithoutTime(masAllotmentOfFundsForMinorWorks.getAllotmentFileDate());
            }
        	else{
        		allotmentDate = "";
        	}
        	if(masAllotmentOfFundsForMinorWorks.getAllotmentFileDate()!= null)
            {
        		fileAmount = masAllotmentOfFundsForMinorWorks.getAllotmentFileAmount();
            }else{
            	fileAmount =new BigDecimal(0);
            }
        	   if(masAllotmentOfFundsForMinorWorks.getAllotmentFileDate()!= null)
               {
        		   remarks = masAllotmentOfFundsForMinorWorks.getRemarks();
               }else{
            	   remarks ="";
               }
        	  
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masAllotmentOfFundsForMinorWorks.getId()%>"
data_arr[<%= counter%>][1] = "<%=finentialYear%>"
data_arr[<%= counter%>][2] = "<%= allotmentFileNO%>"
data_arr[<%= counter%>][3] = "<%=allotmentDate%>"
data_arr[<%= counter%>][4] = "<%=fileAmount.intValue() %>"
data_arr[<%= counter%>][5] = "<%=remarks %>"
<% if(masAllotmentOfFundsForMinorWorks.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "allotmentOfFunds"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
