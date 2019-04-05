<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdVaccin.jsp
 * Purpose of the JSP -  This is for All Vaccin Master.
 * @author  Vishal Jain
 * Create Date: 30 June,2008
 * Revision Date:
 * Revision By:
 * @version 1.1
--%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="java.util.Map.Entry"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdVaccinMst"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script> 
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%

Map<String,String> type = new HashMap<String,String>();	// added by amit das on 05-08-2016
type.put("I", "Immunization");
type.put("A", "ANC");



Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
ArrayList searchOpdVaccinList = (ArrayList)map.get("searchOpdVaccinList");
List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
if(map.get("genderList") != null){
	genderList = (List)map.get("genderList");
}
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %>

<div class="titleBg">
<h2>Opd Vaccinating</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Vaccine Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"	checked="checked" class="radioCheck" /> 
<label>Name of Vaccination</label> 
<input 	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="Vaccin Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'opdMaster?method=searchOpdVaccin')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','opdMaster?method=searchOpdVaccin','checkSearch')" tabindex=1 /> 
<%--- Report Button   <input type="button" name="report" value="Generate Report Based on Search" class="button" onclick="submitForm('search','opdMaster?method=generateReportForOpdVaccin')" tabindex=1  /> --%>
<input type="button" name="Report" value="Generate Report"	class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="OPD_VACCIN_MST">
</form></div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<%

		if(searchOpdVaccinList.size()>0)
		 {

			String strForCode = (String)map.get("vaccinCode");
			String strForCodeDescription = (String)map.get("vaccinName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{

	%><h4> <a href="opdMaster?method=showOpdVaccinJsp">Show All Records</a></h4> <%
			}
		 }

	 if(searchOpdVaccinList.size()==0 && map.get("search") != null)
	  {

	 %><h4> <a href="opdMaster?method=showOpdVaccinJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">

	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= VACCIN_DURATION%>"],[4,"maxDays"]
			,[5,"vaccineDose"],[6,"vaccineType"] ,[7,"genderId"], [8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script></div>

<form name="opdVaccine" method="post" action="">

<input	type="hidden" name="<%= POJO_NAME %>" value="OpdVaccinMst"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VaccinName"><input
	type="hidden" name="title" value="OpdVaccine"><input
	type="hidden" name="<%=JSP_NAME %>" value="opdVaccine"><input
	type="hidden" name="pojoPropertyCode" value="VaccinCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>  Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Vaccinating Code,string,yes" MAXLENGTH="8" tabindex=1 /> 
<label><span>*</span> Name </label> 
<input type="text" name="<%=SEARCH_NAME%>" value="" id="<%=SEARCH_NAME%>"
	validate="Name of Vaccination,string,yes" MAXLENGTH="30" tabindex=1/>
	<div id="ac2update" style="display: none;" class="autocomplete"></div>
	<script type="text/javascript" language="javascript"
							charset="utf-8">
			  function eventCallback(element, entry){ 
						return;
				}
			    new Ajax.Autocompleter('<%=SEARCH_NAME%>','ac2update','opdMaster?method=getVaccinationList',{parameters:'requiredField=<%=SEARCH_NAME%>', callback: eventCallback});

	</script>
	
<script>
			document.opdVaccine.<%=CODE%>.focus();
		</script> 
	<label><span>*</span>Min Days</label> 
	<input type="text"
	name="<%=VACCIN_DURATION%>" value="" class="textbox_date"
	validate="Vaccine Interval,int,yes" MAXLENGTH="4" />
	<div class="clear"></div>
	<label><span>*</span>Max Days</label> 
	<input type="text"
	id="maxDays" name="maxDays" value="" class="textbox_date"
	validate="Vaccine Interval,int,yes" MAXLENGTH="4" />
	
	<label><span>*</span> Dose</label>
	<select name="vaccineDose" id="vaccineDose" validate="Vaccine Dose,int,yes">
	<option value="">Select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	</select>
	
	<label><span>*</span>Type</label>
	<select name="vaccineType" id="vaccineType" validate="Vaccine Type,String,yes">
	<option value="">Select</option>
	<% for(Map.Entry<String, String> entries : type.entrySet()) {%>
	<option value="<%=entries.getKey()%>"><%=entries.getValue()%></option>
	<%} %>
	</select>
	<div class="clear"></div>
<label><span>*</span>Gender</label>
	<select name="genderId" id="genderId" validate="Gender,String,yes">
		<option value="0">Select</option>
	<% for(MasAdministrativeSex g :genderList){%>
	
	<option value="<%=g.getId()%>"><%=g.getAdministrativeSexName()%></option>
	
			<%}%>
	</select>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('opdVaccine','opdMaster?method=addOpdVaccin');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('opdVaccine','opdMaster?method=editOpdVaccin')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	style="display: none;"
	onClick="submitForm('opdVaccine','opdMaster?method=deleteOpdVaccin&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
	
	</form>
	
<div class="clear"></div>

	
	
	
	
	
<script type="text/javascript">

		data_header = new Array();

		data_header[0] = new Array;
		data_header[0][0] = "Vaccine Code"
		data_header[0][1] = "data";
		data_header[0][2] = "25%";
		data_header[0][3] = "<%= CODE%>"

		data_header[1] = new Array;
		data_header[1][0] = "Name of Vaccination"
		data_header[1][1] = "data";
		data_header[1][2] = "40%";
		data_header[1][3] = "<%= SEARCH_NAME %>";

		data_header[2] = new Array;
		data_header[2][0] = "Min Days"
		data_header[2][1] = "data";
		data_header[2][2] = "40%";
		data_header[2][3] = "<%= VACCIN_DURATION %>";

		data_header[3] = new Array;
		data_header[3][0] = "Max Days"
		data_header[3][1] = "data";
		data_header[3][2] = "40%";
		data_header[3][3] = "maxDays";

		data_header[4] = new Array;
		data_header[4][0] = "Dose"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "vaccineDose";
		
		// added by amit das on 05-08-2016
		data_header[5] = new Array;
		data_header[5][0] = "Type"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "vaccineType";

		
		data_header[6] = new Array;
		data_header[6][0] = "Gender"
		data_header[6][1] = "data";
		data_header[6][2] = "15%";
		data_header[6][3] = "genderId";
		
		data_header[7] = new Array;
		data_header[7][0] = ""
		data_header[7][1] = "hide";
		data_header[7][2] = 0;
		data_header[7][3] = "<%= CHANGED_BY%>"

		data_header[8] = new Array;
		data_header[8][0] = ""
		data_header[8][1] = "hide";
		data_header[8][2] = 0;
		data_header[8][3] = "<%= CHANGED_DATE%>"

		data_header[9] = new Array;
		data_header[9][0] = ""
		data_header[9][1] = "hide";
		data_header[9][2] = "15%";
		data_header[9][3] = "<%=CHANGED_TIME %>";


		data_header[10] = new Array;
		data_header[10][0] = "Status"
		data_header[10][1] = "data";
		data_header[10][2] = "15%";
		data_header[10][3] = "<%=STATUS %>";
		
	
		data_arr = new Array();

	<%


	Iterator itr = searchOpdVaccinList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	             OpdVaccinMst  OpdVaccinMst = (OpdVaccinMst)itr.next();
	%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] =  <%= OpdVaccinMst.getId()%>
		data_arr[<%= counter%>][1] = "<%= OpdVaccinMst.getVaccinCode()%>"
		data_arr[<%= counter%>][2] = "<%= OpdVaccinMst.getVaccinName()%>"
		data_arr[<%= counter%>][3] = "<%= OpdVaccinMst.getVaccinDuration()%>"
		<%if(OpdVaccinMst.getVaccinToDays()!=null ){%>
		data_arr[<%= counter%>][4] = "<%= OpdVaccinMst.getVaccinToDays()%>"
		<%}else{%>
		data_arr[<%= counter%>][4] = "-"
		<%}%>
		
		<% if(OpdVaccinMst.getDose()!=null){ %>
		data_arr[<%= counter%>][5] = "<%=OpdVaccinMst.getDose()%>"
		<%}else{%>
		data_arr[<%= counter%>][5] = "-"
		<%}%>
		<% if(type.get(OpdVaccinMst.getVaccinType())!=null){ %>
		data_arr[<%= counter%>][6] = "<%=type.get(OpdVaccinMst.getVaccinType())%>"
		<%}else{%>
		data_arr[<%= counter%>][6] = "-"
		<%}%>

		<%
		Iterator itrGridGenderList=genderList.iterator();
		 while(itrGridGenderList.hasNext())
	        {try{
	        	MasAdministrativeSex  genderGrid = (MasAdministrativeSex)itrGridGenderList.next();
			 if(OpdVaccinMst.getGender().getId().equals(genderGrid.getId()) && genderGrid.getStatus().equalsIgnoreCase("Y")){%>
				data_arr[<%= counter%>][7] = "<%=genderGrid.getAdministrativeSexName().trim()%>"
			<%}else if(OpdVaccinMst.getGender().getId().equals(genderGrid.getId()) && genderGrid.getStatus().equalsIgnoreCase("N")){%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=genderGrid.getAdministrativeSexName().trim()%>";

			<%}
	        }catch(Exception e){}}%>
		data_arr[<%= counter%>][8] = "<%= OpdVaccinMst.getLastChgBy()!= null?OpdVaccinMst.getLastChgBy().getId():"" %>"
		data_arr[<%= counter%>][9] = "<%=OpdVaccinMst.getLastChgDate() != null?HMSUtil.convertDateToStringWithoutTime(OpdVaccinMst.getLastChgDate()):""%>"
		data_arr[<%= counter%>][10] = "<%= OpdVaccinMst.getLastChgTime()!= null?OpdVaccinMst.getLastChgTime():"" %>"
		<% if(OpdVaccinMst.getStatus().equals("y")){ %>
		data_arr[<%= counter%>][11] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][11] = "InActive"
		<%}%>
		

		<%
				     counter++;
		}
		%>

		formName = "opdVaccine"


		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);

		intializeHover('searchresulttable', 'TR', ' tableover');
		</script>
