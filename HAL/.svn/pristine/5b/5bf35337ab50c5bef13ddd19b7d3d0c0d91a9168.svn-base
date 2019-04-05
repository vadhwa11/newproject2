<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.Holidaycalendar"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<!-- 
<script type="text/javascript" language="javascript" src="/erp/jsp/js/common.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
 -->
<!-- <script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script> -->

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>
<script language="javascript">

var $j = jQuery.noConflict();
</script>
<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String sdate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
Date d= new Date();
		
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		if(map.get("holidayMasterList") != null){
			holidayMasterList = (List)map.get("holidayMasterList");
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
		System.out.println("userName"+userName);
		if(map.get("message") != null){
		String message = (String)map.get("message");
		out.println("<h4>"+message+"</h4>");
		}
%>
<script language="javascript">
<%
		Calendar calendar=Calendar.getInstance();
	
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
		
%>

serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<div class="titleBg"><h2>Holiday Master</h2></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>"   value="1" checked="checked" class="radioCheck" style="margin-right:10px;" />
<label>Year</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" style="margin-right:10px;" />

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Payroll Description,string,no"   MAXLENGTH="20" tabindex=1  onkeypress="return submitenter(this,event,'payrollMasters?method=searchPayroll')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','systemRelatedMaster?method=searchHolidayMaster','checkSearch')" tabindex=1  />
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
if(holidayMasterList.size()>0)
{
String strForName = (String)map.get("name");
String strForyear = (String)map.get("year");
if(strForName!= null && strForName!= "" || strForyear!= null && strForyear!= "")
{
%> 


<!-- <a href="systemRelatedMaster?method=showHolidayMasterJsp">Show All Records</a> -->
<a href="javascript:void(0)" onclick="submitForm('ancher','systemRelatedMaster?method=showHolidayMasterJsp');">Show All Records</a>
<%
}
}
if(holidayMasterList.size()==0 && map.get("search") != null)
{
%>
<!-- <a href="systemRelatedMaster?method=showHolidayMasterJsp">Show All Records</a> -->
<a href="javascript:void(0)" onclick="submitForm('ancher','systemRelatedMaster?method=showHolidayMasterJsp');">Show All Records</a>

<%
}
%>
<script type="text/javascript">

formFields = [
[0, "<%=HOLIDAY_MASTER_ID%>", "id"], [1,"<%=DESCRIPTION%>"], [2,"<%=YEAR %>"],[3,"<%= HOLIDAY_DATE%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=CHANGED_BY%>"],[7,"<%=RH%>"],[8,"<%=STATUS%>"] ];
statusTd = 8;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="holidayMaster" method="post" action="">
<div class="Block">
<%-- <label><span>*</span>Year</label>
<select  name="<%=YEAR%>" validate="Year,string,yes" ">
<option value="0">Select</option>
<option value="2009">2009</option>
<option value="2010">2010</option>
<option value="2011">2011</option>
<option value="2012">2012</option>
<option value="2013">2013</option>
<option value="2014">2014</option>
<option value="2015">2015</option>
<option value="2016">2016</option>
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2019">2019</option>
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
<option value="2025">2025</option>
<option value="2026">2026</option>
<option value="2027">2027</option>
<option value="2028">2028</option>
<option value="2029">2029</option>
<option value="2030">2030</option>
</select> --%>
<label>Holiday Date<span>*</span> </label>
 <input name="<%=HOLIDAY_DATE%>" id="fd" type="text"  tabindex="1" class="calDate" size="7"  maxlength="10" onchange="yearval();"  validate='Holiday Date,date,yes' value=""   />

 <label>Year <span>*</span></label> 
<input name="<%=YEAR%>" id="y" type="text"  validate='Year ,int,yes'  tabindex="1" maxlength="4"  onblur="yearValidation(this.value,event)"  value=""    readonly="readonly"/>
 

<label>Name<span>*</span> </label>
<input id="codeId" type="text" name="<%=DESCRIPTION%>" value="" validate="Name,string,yes" maxlength="200" />
<div class="clear"></div>
<label><span>*</span>RH</label>
<select  name="<%=RH%>" validate="RH,string,yes">
<option value="0">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</div>
<div class="clear"></div>

<div class="division"></div>

<div id="edited"></div>


<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('holidayMaster','systemRelatedMaster?method=addHolidayMaster');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('holidayMaster','systemRelatedMaster?method=editHolidayMaster')" accesskey="u" tabindex=1 />

<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('holidayMaster','systemRelatedMaster?method=deleteHolidayMaster&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<div class="clear"></div>

<div class="division"></div>
<div class="bottom">
<label>Changed By</label>   
<label class="value"><%=userName%></label>

<label>Changed Date</label>   
<label class="value"><%=date%></label>

<label>Changed Time</label>   
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=sdate%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
</div>	
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%=HOLIDAY_MASTER_ID%>" value="" />
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%=DESCRIPTION%>"

data_header[1] = new Array;
data_header[1][0] = "Year"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=YEAR%>";

data_header[2] = new Array;
data_header[2][0] = "Holiday Date"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= HOLIDAY_DATE %>"

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
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = "RH"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=RH %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";


data_arr = new Array();
<%
Iterator itr=holidayMasterList.iterator();
int  counter=0;
while(itr.hasNext())
 {            
Holidaycalendar  holidaycalendar= (Holidaycalendar)itr.next();     
 %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= holidaycalendar.getId()%>
data_arr[<%= counter%>][1] = "<%=holidaycalendar.getTitle()%>"


data_arr[<%= counter%>][2] = "<%=holidaycalendar.getHolidayListYear()%>"


            
data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(holidaycalendar.getHolidayDate())%>"

<%if(holidaycalendar.getLastChgDate() !=null){%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(holidaycalendar.getLastChgDate()) %>"
<%}else{%>
data_arr[<%= counter%>][4] = ""
<%}%>

data_arr[<%= counter%>][5] = "<%= holidaycalendar.getLastChgTime() %>"
data_arr[<%= counter%>][6] = "<%= holidaycalendar.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= holidaycalendar.getRh() %>"
<% 
if(holidaycalendar.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else if(holidaycalendar.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][8] = "InActive"
<%
   }	counter++;
	}
%>



formName = "holidayMaster"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		

function yearval()
{ 
		 var fd=document.getElementById("fd").value;
		
		if(fd!=""){
			
			var d = new Date(fd.substring(6),(fd.substring(3,5) - 1) ,fd.substring(0,2));
			var nextYear = new Date(fd.substring(6),(fd.substring(3,5) - 1) ,fd.substring(0,2)).getFullYear() +1;
			var month = d.getMonth() + 1;
			var day =  d.getDate();
			
	
			var year = d.getFullYear();
			var next= year+1;
			var seperator = "-" ;
			  if(d.getDate() < 10){
	       			
	       			//dt = "0"+day;
	       			dt = "31";
	       		}
	       		else
	       		{
	       			//dt = day;
	       			dt = "31" ;
	       		} 
	       		
	       		if(d.getMonth()+1 < 10){
	       			//mth = "0"+month
	       			mth = "03";
	       		}
	       		else
	       		{
	       			mth = "03";
	       		}
	      
	      	//var myDate = (dt + "/" + mth + "/" + next);
	      	//document.getElementById("td").value=myDate;
		 	document.getElementById("y").value=year;
		 	//var fy = year + seperator + next;
			//document.getElementById("fy").value=fy;
			return true;
}
}

function yearValidation(year) {
    var text = /^[0-9]+$/;
    if (year != 0) {
        if ((year != "") && (!text.test(year))) {

            alert("Please Enter Numeric Values Only");
            return false;
        }

     
         var fd=document.getElementById("fd").value;
		if(fd!=""){
			var d = new Date(fd.substring(6),(fd.substring(3,5) - 1) ,fd.substring(0,2));
			var dc = d.getFullYear();
		if((year < dc))
            {
            alert("Year should be in from date same year");
            return false;
            }
		}
        return true;
 }
}
</script>
