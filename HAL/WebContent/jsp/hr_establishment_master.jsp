<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.15  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>
<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
		
	ArrayList searchEstablishmentList = (ArrayList)map.get("searchEstablishmentList");
	List<MasRank>rankList=new ArrayList<MasRank>();
	List<MasUnit>unitList=new ArrayList<MasUnit>();
	List<HrSpecialistMaster>specialityList=new ArrayList<HrSpecialistMaster>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	if(map.get("unitList")!=null)
	{
		unitList=(List<MasUnit>)map.get("unitList");	
	}
	if(map.get("rankList")!=null)
	{
		rankList=(List<MasRank>)map.get("rankList");	
	}
	if(map.get("specialityList")!=null)
	{
		specialityList=(List<HrSpecialistMaster>)map.get("specialityList");	
	}


%>
<h2 align="left" class="style1">Establishment Master for Medical
Assistant</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">Unit:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="bodytextB_blue">Speciality:</font>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="unit,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hrRelatedMaster?method=searchEstablishment')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrRelatedMaster?method=searchEstablishment','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="button"
	onClick="" accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_country"></form>

</div>

</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
	 if(map.get("search") != null)
	  {
	 %> <a href="hrRelatedMaster?method=showEstablishmentJsp">Show All
Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= UNIT_NAME%>"], [2,"<%=SPECIALITY_NAME%>"], [3,"<%=RANK_NAME%>"], [4,"<%=STRENGTH%>"], [5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"],[9,"<%=MANNING_LEVEL%>"] ];
	 statusTd = 9;
	</script></div>
<br />
<form name="establishment" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrEstablishmentMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="Strength">
<input type="hidden" name="title" value="Establishment"> <input
	type="hidden" name="<%=JSP_NAME %>" value="Establishment"> <input
	type="hidden" name="pojoPropertyCode" value="Strength"> <br>

<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font>Unit Name</label> <select name="<%=UNIT_NAME%>"
	validate="unit,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%if(unitList!=null)
		{
			for (MasUnit masUnit : unitList)
			{	
		%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}} %>
</select> <label id=biglabel class="bodytextB_blue"><font id="error">*</font>Speciality
Name</label> <select name="<%=SPECIALITY_NAME%>"
	validate="Speciality,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%if(specialityList!=null)
		{
			for (HrSpecialistMaster hrSpecialistMaster : specialityList)
			{
		%>
	<option value="<%=hrSpecialistMaster.getId()%>"><%=hrSpecialistMaster.getSpecialistName()%></option>
	<%} }%>
</select> <label id=biglabel class="bodytextB_blue"><font id="error">*</font>Rank
Name</label> <select name="<%=RANK_NAME%>" validate="Rank,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%if(rankList!=null)
		{
			for (MasRank masRank : rankList)
			{
		%>
	<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
	<%}} %>
</select> <label id=biglabel class="bodytextB_blue"><font id="error">*</font>Strength</label>
<input type="text" name="<%= STRENGTH %>" value=""
	validate="Strength,int,yes" class="textbox_size20" MAXLENGTH="5"
	tabindex=1 /> <label id=biglabel class="bodytextB_blue"><font
	id="error">*</font>Manning Level</label> <input type="text" name="manningLevel"
	value="" validate="Manning Level,int,yes" class="textbox_size20"
	MAXLENGTH="5" tabindex=1 /> <script>
				document.establishment.<%=UNIT_NAME%>.focus();
			</script>
<div class="Clear"></div>
<div class="Clear"></div>
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('establishment','hrRelatedMaster?method=addEstablishment');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('establishment','hrRelatedMaster?method=editEstablishment')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('establishment','hrRelatedMaster?method=deleteEstablishment&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Unit Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%=UNIT_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Speciality Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=SPECIALITY_NAME%>";

data_header[2] = new Array;
data_header[2][0] = "Rank Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= RANK_NAME%>";

data_header[3] = new Array;
data_header[3][0] = "Strength"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= STRENGTH%>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_TIME %>"

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_header[8] = new Array;
data_header[8][0] = "Manning Level"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=MANNING_LEVEL%>";

data_arr = new Array();

<%
if(searchEstablishmentList!=null){
Iterator itr=searchEstablishmentList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrEstablishmentMaster hrEstablishmentMaster = (HrEstablishmentMaster)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrEstablishmentMaster.getId()%>
<%for(MasUnit masUnit:unitList){
	if(masUnit.getId()==hrEstablishmentMaster.getUnit().getId()){
%>
	data_arr[<%= counter%>][1] = "<%= masUnit.getUnitName()%>"
<%}}%>
data_arr[<%= counter%>][2] = "<%= hrEstablishmentMaster.getSpeciality().getSpecialistName()%>"
data_arr[<%= counter%>][3] = "<%= hrEstablishmentMaster.getRank().getRankName()%>"
data_arr[<%= counter%>][4] = "<%= hrEstablishmentMaster.getStrength()%>"
data_arr[<%= counter%>][5] = "<%= hrEstablishmentMaster.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(hrEstablishmentMaster.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= hrEstablishmentMaster.getLastChgTime() %>"
<% if(hrEstablishmentMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
data_arr[<%= counter%>][9] = "<%= hrEstablishmentMaster.getManningLevel() %>"
<%
		     counter++;
}}
%>
formName = "establishment"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
