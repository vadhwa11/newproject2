
<%@ page import="java.net.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasImpanneledHospital"%>

<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script> <%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchImpanneledHospitalList = (ArrayList)map.get("searchImpanneledHospitalList");
String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}
%> <%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><%=message %></h4> <% 
	  }

%>
<div class="titleBg"><h2>Impanneled Hospital Master</h2></div>
<div class="clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label class="auto">Impanneled Hospital Code</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>" 	value="1" checked="checked" />
<label label class="auto">Impanneled Hospital Name</label>
<input	type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>"  value="2" />
<input	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="ImpanneledHospital Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=searchMasImpanneledHospital')" />

<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchImpanneledHospital','checkSearch')"	tabindex=1 />
				<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="mas_ImpanneledHospital">
</div>
</form>
<div class="Clear"></div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchImpanneledHospitalList.size()>0)
		 {
			String strForCode = (String)map.get("impanneledHospitalCode");
			String strForCodeDescription = (String)map.get("impanneledHospitalName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>


<h4><a href="generalMaster?method=showImpanneledHospitalJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchImpanneledHospitalList.size()==0 && map.get("search") != null)
	  {
	 %>
<h4><a href="generalMaster?method=showImpanneledHospitalJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= ADDRESS %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"]];
	 statusTd = 7;
	</script></div>
<div class="clear"></div>

<form name="impanneledHospital" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasImpanneledHospital"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ImpanneledHospitalName">
<input type="hidden" name="title" value="ImpanneledHospital"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="impanneledHospital"> 
<input	type="hidden" name="pojoPropertyCode" value="ImpanneledHospitalCode">

	  		
	  		
 <div class="Clear"></div>
<div class="Block">

<label label class="auto">Impanneled Hospital Code <span>*</span></label>
<input id="codeId" type="text" name="<%= CODE%>" value=""	validate="Impanneled Hospital Code,string,yes" MAXLENGTH="299" tabindex=1 />
<label label class="auto">Impanneled Hospital Name<span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Impanneled Hospital Name,string,yes" MAXLENGTH="299" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addImpanneledHospital')" />
<script>
				document.impanneledHospital.<%=CODE%>.focus();
</script>

<label>Address </label> 
<textarea maxlength="500" rows="0" name="<%=ADDRESS %>" onkeyup="return ismaxlength(this)"  tabindex="1"></textarea>

</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>

<input type="button" name="Submit11" id="addbutton" value="Add" 	class="button"	onClick="submitForm('impanneledHospital','generalMaster?method=addImpanneledHospital')"	accesskey="a" tabindex=1 />
<input type="button" name="edit"	id="editbutton" value="Update" class="button"	onClick="submitForm('impanneledHospital','generalMaster?method=editImpanneledHospital')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	onClick="submitForm('impanneledHospital','generalMaster?method=deleteImpanneledHospital&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('impanneledHospital','/hms/hms/generalMaster?method=showImpanneledHospitalJsp')" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>     
<label	class="value"><%=userName %></label> 
<label>Changed Date:</label> 
<label	class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
   </div>	
	<div class="Clear"></div>
</form>



<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Impanneled Hospital Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Impanneled Hospital Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Address"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "<%= ADDRESS%>"


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
Iterator itr=searchImpanneledHospitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasImpanneledHospital  masImpanneledHospital = (MasImpanneledHospital)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masImpanneledHospital.getId()%>
data_arr[<%= counter%>][1] = "<%=masImpanneledHospital.getImpanneledHospitalCode()%>"
data_arr[<%= counter%>][2] = "<%= masImpanneledHospital.getImpanneledHospitalName()%>"

<%
String addressSmc="";
if(masImpanneledHospital.getAddress()!=null){
	addressSmc=masImpanneledHospital.getAddress();
	
	addressSmc = addressSmc.replace("\r", "$");
	//addressSmc = addressSmc.replace("\t", "@");
	addressSmc = addressSmc.replace("\n", "^");
	
	//System.out.println("addressSmc="+addressSmc);
}

%>

var str_esc = "<% out.print(addressSmc); %>";
 // var str_esc=str_esc.replace(/$/g,"\r");
  str_esc = str_esc.split('$').join("\r");
  str_esc = str_esc.split('^').join("\n");
  
  //console.log("str_esc="+str_esc);
  //str_esc = str_esc.replace("^","\n")
  
 data_arr[<%= counter%>][3] = str_esc;
<%-- data_arr[<%= counter%>][3] = "kjsa,hhhsd, # 32/56"; --%>

data_arr[<%= counter%>][4] = "<%= masImpanneledHospital.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masImpanneledHospital.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masImpanneledHospital.getLastChgTime() %>"
<% if(masImpanneledHospital.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>


<%
		     counter++;
}
%>
 
formName = "impanneledHospital"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
