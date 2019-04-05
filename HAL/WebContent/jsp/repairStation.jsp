<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * financial.jsp  
 * Purpose of the JSP -  This is for Financial Description.
 * @author  Priyanka
 * Create Date: 13th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.4
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasRepairStation;"%>

<script>
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
function check(){
var SDate = document.financial.<%= START_DATE%>.value;
var EDate = document.financial.<%= END_DATE %>.value;

if (SDate == '' || EDate == '') {
alert("Plesae enter both....");
return false;
}

var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the End Date is greater than or equal to the Start Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	Map map = new HashMap();
	List searchFinancialList = new ArrayList();
	List<MasRepairStation>repairStationList=new ArrayList<MasRepairStation>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	
	if(map.get("repairStationList") != null){
		repairStationList = (List)map.get("repairStationList");
		System.out.println("searchFinancialList ----- in jsp"+repairStationList.size());
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	
}

%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Repair Station Master</h2></div>
<div class="clear"></div>

   <div id="searcharea">
   
    <div id="searchbar">
    
     <form name="search" method="post" action="">
     <div class="Block">
       <label>Repair Station Code</label>
        <input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
      <label>Repair Station Name</label>
     <input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />
    
      <input type="text" id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Start Date,date,no"   MAXLENGTH="10" tabindex=1  onkeypress="return submitenter(this,event,'pharmacy?method=searchFinancial')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','pharmacy?method=searchFinancial','checkSearch')" tabindex=1  />
		            <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_store_financial">
                    
       </div>             
       </form>
<div class="clear"></div>
</div>
   </div>
  

      
 <div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
 <div id="searchresults" tabindex=2 >
 <div id="searchtable" tabindex=2 ></div>
 
 <% 
  if(searchFinancialList.size()>0)
   {
   String strForCode = (String)map.get("startDate");
   String strForCodeDescription = (String)map.get("endDate");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
  
  
    <h4> <a  href="pharmacy?method=showFinancialJsp">Show All Records</a></h4>
 <%
   }
   }
   
 if(searchFinancialList.size()==0 && map.get("search") != null)
 {
%>
		 <h4> <a  href="pharmacy?method=showFinancialJsp">Show All Records</a></h4>

<%
}
%>

 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= NAME %>"],[3,"<%= STATUS %>"]];
  statusTd = 3;
 </script>
 </div>
 
  <form name="repairStation" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasRepairStation">
  <input type="hidden" name="financial" value = "Financial">
  <input type="hidden" name="<%=JSP_NAME %>" value = "repairStation">
 
  
<div class="clear"></div>   
<div class="clear"></div>
<div class="Block">		
		
<label>Repair Station Code</label>
<input type="text" id="startDateId" name="<%=CODE%>" value=""  validate="Repair Station Name,String,yes"  MAXLENGTH="30"  />

<label>Repair Station Name</label>
<input type="text" id="endDateId" name="<%=NAME%>" value=""  validate="Repair Station Name,String,yes"  MAXLENGTH="100" />
		

    
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('repairStation','pharmacy?method=addRepairStation');" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('repairStation','pharmacy?method=editRepairStation')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('repairStation','pharmacy?method=deleteRepairStation&flag='+this.value)" accesskey="d" tabindex=1/>  
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date</label>   
<label class="value"><%=date%></label>
			 
<label>Changed Time</label>   
<label class="value"><%=time%></label>
			 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  

</div> 

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Repair Station Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Repair Station Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Status"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=repairStationList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  MasRepairStation   masRepairStation = (MasRepairStation)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masRepairStation.getId()%>
data_arr[<%= counter%>][1] = "<%= masRepairStation.getStationCode() %>"
data_arr[<%= counter%>][2] = "<%= masRepairStation.getStationName() %>"

<% if(masRepairStation.getStatus().equals("y")){ %>
data_arr[<%= counter%>][3] = "Active"
<%}else{%>
data_arr[<%= counter%>][3] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "repairStation"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>
 </form>