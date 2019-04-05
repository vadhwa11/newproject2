<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdHoliday.jsp  
 * Purpose of the JSP -  This is for All OpdHoliday Master.
 * @author  Mansi
 * Create Date: 25 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdHoliday"%>
<script type="text/javascript">
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
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> 
<script type="text/javascript">
function yearValid(){
var d = new Date();
var yearNow=d.getFullYear()-1;

var hDateId = document.getElementById('hDateId').value ;
if(hDateId!="")
{
	  var v = new Date(hDateId.substring(6),(hDateId.substring(3,5) - 1) ,hDateId.substring(0,2));

      var curr_date = v.getDate();
      
      var curr_month = v.getMonth()+1;
      
      var curr_year = v.getFullYear();
 	 
      if(curr_year<=yearNow)
      {
      	alert("Please Not before year from  current year");
      	document.getElementById('hDateId').value="";
      	return false;
      }
      else
      {	
      	var mth;
      	var dt;
     	if(v.getDate() < 10){
       			
       			dt = "0"+curr_date;
       		}
       		else
       		{
       			dt = curr_date;
       		}
       		
       		if(v.getMonth()+1 < 10){
       			mth = "0"+curr_month
       		}
       		else
       		{
       			mth = curr_month
       		}
      
      var myDate = (dt + "/" + mth + "/" + curr_year);

	  document.getElementById('hDateId').value=myDate;
	  return true;
	}
	}
	else
	{
	  document.getElementById('hDateId').value="";
	  return false;
	}
	return true;
	}
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchOpdHolidayList = (ArrayList)map.get("searchOpdHolidayList");
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
departmentList = (List<MasDepartment>)map.get("departmentList");
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
		  <h4><span><%=message %></span></h4>
		 
		 <% }%>
<div class="titleBg"><h2>Opd Holiday</h2></div>
<div class="clear"></div>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">
<label>Holiday Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Holiday Name</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" />

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Holiday Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'opdMaster?method=searchOpdHoliday')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','opdMaster?method=searchOpdHoliday','checkSearch')"
	tabindex=1 />
	</div>
	</form>
<div class="clear"></div>

</div>
</div>


<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchOpdHolidayList.size()>0)
		 {
			String strForCode = (String)map.get("holidayCode");
			String strForCodeDescription = (String)map.get("holidayName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 

<h4><a href="opdMaster?method=showOpdHolidayJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchOpdHolidayList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="opdMaster?method=showOpdHolidayJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= HOLIDAY_DATE %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="opdHoliday" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="OpdHoliday"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="HolidayName">
<input type="hidden" name="title" value="OpdHoliday"> <input
	type="hidden" name="<%=JSP_NAME %>" value="opdHoliday"> <input
	type="hidden" name="pojoPropertyCode" value="HolidayCode"> 

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">


<label>  Holiday Code <span>*</span></label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Holiday Code,string,yes"  MAXLENGTH="8"
	/ tabindex=1> 
	
<label> Holiday Name <span>*</span></label> <input type="text"
	name="<%= SEARCH_NAME %>" value="" validate="Holiday Name,string,yes"
	 MAXLENGTH="30" / tabindex=1
	onkeypress="return submitenter(this,event,'opdMaster?method=addOpdHoliday')">
<script>
				document.opdHoliday.<%=CODE%>.focus();
				</script>
				
	 <label> Holiday Date<span>*</span> </label>
	  <input type="text" class="calDate" id="hDateId" name="<%=HOLIDAY_DATE%>" value=""	 readonly="readonly"
	validate="Holiday Date,date,yes" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
	onClick="setdate('',document.opdHoliday.<%=HOLIDAY_DATE%>,event)" />
	
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>


<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('opdHoliday','opdMaster?method=addOpdHoliday','yearValid');" accesskey="a" tabindex=1 />
<input type="button" name="edit"	id="editbutton" value="Update" class="button" onClick="submitForm('opdHoliday','opdMaster?method=editOpdHoliday')"	accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" onClick="submitForm('opdHoliday','opdMaster?method=deleteOpdHoliday&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>

<label>Changed Date</label>
<label class="value"><%=date%></label>

<label>Changed Time</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
		<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
	</div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Holiday Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Holiday Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Holiday Date"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= HOLIDAY_DATE %>";



data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>";


data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchOpdHolidayList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             OpdHoliday  opdHoliday = (OpdHoliday)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= opdHoliday.getId()%>
data_arr[<%= counter%>][1] = "<%=opdHoliday.getHolidayCode()%>"
data_arr[<%= counter%>][2] = "<%= opdHoliday.getHolidayName()%>"


data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(opdHoliday.getHolidayDate()) %>"
data_arr[<%= counter%>][4] = "<%= opdHoliday.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(opdHoliday.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= opdHoliday.getLastChgTime() %>"
<% if(opdHoliday.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "opdHoliday"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
