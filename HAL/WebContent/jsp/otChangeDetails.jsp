<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * otChangeDetails.jsp  
 * Purpose of the JSP -  This is for All OtChangeDetails Master.
 * @author  Mansi
 * Create Date: 5 Sep,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.OtMasChargeDetails"%>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<div id="contentHolder">
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

ArrayList searchOtMasChangeDetailsList = (ArrayList)map.get("searchOtMasChangeDetailsList");

List<MasChargeCode> masChargeCodeList = new ArrayList<MasChargeCode>();
masChargeCodeList = (List<MasChargeCode>)map.get("masChargeCodeList");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }
int otMasChargeDetailsId=0;
if(map.get("otMasChargeDetailsId") != null){
	    otMasChargeDetailsId = (Integer)map.get("otMasChargeDetailsId");

	  }
System.out.println("masChargeCodeList in jsp"+masChargeCodeList.size());
%>

<h6>OT Charge Details</h6>


<div class="header">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action=""><label>Charge
Code Name:</label> <label>&nbsp;</label> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" validate="Days,string,no"
	MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'otMaster?method=searchOtMasChargeDetails')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','ot?method=searchOtMasChargeDetails','checkSearch')"
	tabindex=1 /></form>
</div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
 System.out.println("searchOtMasChangeDetailsList in jsp>>>>>>>>>>>>"+searchOtMasChangeDetailsList.size());
  if(searchOtMasChangeDetailsList.size()>0)
   {
   String strForGroupName = (String)map.get("chargeCodeName");
    if(strForGroupName!= null && strForGroupName!= "" )
   {
 %> <a href="otMaster?method=showOtMasChargeDetailsJsp">Show All
Records</a> <%
		
		  }
	   }
	 if(searchOtMasChangeDetailsList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="otMaster?method=showOtMasChargeDetailsJsp">Show All
Records</a> <%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CHARGE_CODE_NAME%>"], [2,"<%= TYPE_OF_REG %>"],[3,"<%= TIME%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
  statusTd =7;
 </script></div>

<div class="Clear"></div>
<form name="otMasChargeDetails" method="post" action="">
<div id="contentoperation">

<div class="division"></div>

<label class="bodytextB1"><font id="error">*</font>Charge Code
Name:</label> <input type="text" value="" id="chargeCodeName" class="bigcaption"
	validate="Charge Code Name.,String,yes" name="chargeCodeName"
	onblur="fillChargeCode(this.value);" />
<div id="ac2update"
	style="display: none; padding-right: 550px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('chargeCodeName','ac2update','otMaster?method=getChageCodeByAutocomplete',{parameters:'requiredField=chargeCodeName'});
		</script> <input type="hidden" value="" name="<%=CHARGE_CODE_ID%>"
	id="chargeCodeId" /> <label class="noWidth"> Type <span>*</span>
</label> <select name="<%=TYPE_OF_REG%>" validate="Type,string,yes" tabindex=1>
	<option value="0">Select</option>
	<option value="Major">Major</option>
	<option value="Minor">Minor</option>
</select> <label class="noWidth">Approx Duration(HH:MM) <span>*</span></label> <input
	type="text" tabindex=1 id="approxDuration" name="<%=TIME%>" value=""
	class="textbox_date" validate="Approx Duration,string,yes"
	MAXLENGTH="5" onChange="convertTime(this.value);" /></div>
<div class="division"></div>
<div class="Height10"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label class="bodytextB">Changed
Time:</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('otMasChargeDetails','otMaster?method=addOtMasChargeDetails');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('otMasChargeDetails','otMaster?method=editOtMasChargeDetails')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('otMasChargeDetails','otMaster?method=deleteOtMasChargeDetails&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /></div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Charge Code Name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CHARGE_CODE_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Type"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%= TYPE_OF_REG %>";


data_header[2] = new Array;
data_header[2][0] = " Approx Time"
data_header[2][1] = "data";
data_header[2][2] = "20%";
data_header[2][3] = "<%= TIME%>"


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
data_header[6][2] = "10%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchOtMasChangeDetailsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  OtMasChargeDetails  masChargeDetails = (OtMasChargeDetails)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masChargeDetails.getId()%>

<%
Iterator itroTList=masChargeCodeList.iterator();
while(itroTList.hasNext())
      {
	MasChargeCode  masChargeCode = (MasChargeCode)itroTList.next(); 
	 if(masChargeDetails.getChargeCode().getId().equals(masChargeCode.getId()) && masChargeCode.getStatus().equals("y")){
		 int  chargeCodeId=masChargeCode.getId();
	 %>
		
		data_arr[<%= counter%>][1] = "<%=masChargeCode.getChargeCodeName()%>[<%=chargeCodeId%>]";
	<%}else if(masChargeDetails.getChargeCode().getId().equals(masChargeCode.getId()) && masChargeCode.getStatus().equals("n")){%>
		data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masChargeCode.getChargeCodeName()%>[<%=masChargeCode.getId()%>]";
	<%}
}%>

data_arr[<%= counter%>][2] = "<%= masChargeDetails.getOtChargeType()%>"
data_arr[<%= counter%>][3] = "<%= masChargeDetails.getApproxDuration()%>"
data_arr[<%= counter%>][4] = "<%= masChargeDetails.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masChargeDetails.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masChargeDetails.getLastChgTime() %>"
<% if(masChargeDetails.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "otMasChargeDetails"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  


</script>
<script>

 function fillChargeCode(val) {
	
	  	  	var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		    if(id ==""){
			  return;
			}else{
			obj =document.getElementById('chargeCodeId'); 
			obj.value = id;
					
			}
	    
	  }
function convertTime(field) {
  pattern = /^(24):(00)|([01][0-9]|2[0-3]):([0-5][0-9])$/;
  if(pattern.test(field)==false)
  {
  alert("Please enter valid format HH:MM ");
  field.focus();
  }
 }
</script>