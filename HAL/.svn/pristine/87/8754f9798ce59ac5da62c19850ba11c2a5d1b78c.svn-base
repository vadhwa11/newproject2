<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReturn.jsp  
 * Purpose of the JSP -  This is for ed Return.
 * @author  Deepti
 * @author  Ritu  
 * Create Date: 22nd Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.3
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
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
		
		
	
				
					function calculateEdDate()
					{
						var currentDate=new Date();
						var edDate=null;
						var edDays;
						var dateOfEd;
						edDays=document.EDReturns.noOfDays.value;
									
						var toYear=1900+currentDate.getYear();
						
						var toMonth=currentDate.getMonth()+1;
						
						var toDay=currentDate.getDate();
						if(toDay==31 && toMonth==12)
						{
							toYear=eval(toYear)+1;
							toDay=edDays;
							toMonth=01;
						}
						else if(toDay==31 && (toMonth==01 || toMonth==03 || toMonth==05 || toMonth==07 || toMonth==8 || toMonth==10))
						{
							toDay=edDays;
							toMonth=eval(toMonth)+1;
						}
						else if(toDay==30 && (toMonth==02 || toMonth==04 || toMonth==06 || toMonth==9 || toMonth==11 ))
						{
							toDay=edDays;
							toMonth=eval(toMonth)+1;
						}
						else
						{
							toDay=eval(toDay)+eval(edDays);
						}
						
						if((toDay>31 && (toMonth==01 || toMonth==03 || toMonth==05 || toMonth==07 || toMonth==8 || toMonth==10)) || (toDate>30 && (toMonth==02 || toMonth==04 || toMonth==06 || toMonth==9 || toMonth==11 )))
						{
								alert("Wrong ED Days entered!!");
								document.EDReturns.noOfDays.value="";
						}
						else
						{						
								edDate=toDay+"/"+toMonth+"/"+toYear;
									
								dateOfEd=document.EDReturns.dateOfEd;
							
								dateOfEd.value=edDate;
						}		
						
									
					}
				
				
				
	</script> <br />
<h2 align="left" class="style1">Exercise Duty Returns</h2>
<br />


<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 				 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					
			 	List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
			 	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
			 	List<Patient> patientList = new ArrayList<Patient>();
			 	List<Visit> visitList = new ArrayList<Visit>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
				String category=null;
			 	
				
			 	if (map.get("rankCategoryList") != null) {
			 		rankCategoryList = (List<MasRankCategory>) map.get("rankCategoryList");
			 	}
			 	if (map.get("disposalList") != null) {
			 		disposalList = (List<MasDisposal>) map.get("disposalList");
			 	}
			 	if (map.get("patientList") != null) {
			 		patientList = (List<Patient>) map.get("patientList");
			 	}
			 	if (map.get("showList") != null) {
			 		visitList = (List<Visit>) map.get("showList");
			 		session.setAttribute("visitList", visitList);
			 	}
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
			 	}
			 	if (map.get("category") != null) {
			 		category = (String) map.get("category");
			 		session.setAttribute("category", category);
			 	}
			 	
			 	
			 %>

<form name="search" method="post" action=""><label> From
Date:</label> <input type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currenDate %>',document.search.<%=FROM_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label> To Date:</label> <input
	type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currenDate %>',document.search.<%=TO_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <Label>Ed Status:</Label>

<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"
	checked="checked" /> <font class="bodytextB_blue">No</font> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" /> <font
	class="bodytextB_blue">Yes</font> <label>Category :</label> <select
	id="categoryId" name="<%=CATEGORY_ID %>">

	<%
							for (MasRankCategory masRankCategory : rankCategoryList) {
						%>
	<option value="<%=masRankCategory.getId() %>"><%=masRankCategory.getRankCategoryName()%></option>
	<%
						}
					%>
</select> <br />

<input type="button" name="show" value="Show" class="button"
	onClick="submitForm('search','mis?method=showEDReturns');" /></form>


<br />


<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">
		
				formFields = [
					[0, "<%= VISIT_ID%>", "id"],[1, "<%= RANK_ID%>", "id"], [2,"<%= PATIENT_NAME%>"], [3,"<%= TRADE_ID %>"],[4,"<%=VISIT_NUMBER%>"], [5,"<%= VISIT_DATE %>"],[6,"<%= UNIT_NAME %>"],[7,"<%=NO_OF_DAYS%>"],[8,"<%=DATE_OF_ED%>"],[9,"<%=DISPOSAL_ID%>"],[10,"<%=STATUS%>"] ];
		 			statusTd = 10;
				</script></div>
<br />

<form name="EDReturns" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="Visit"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VisitNo">
<input type="hidden" name="title" value="EDReturns"> <input
	type="hidden" name="<%=JSP_NAME %>" value="EDReturns"> <input
	type="hidden" name="pojoPropertyCode" value="VisitNo">


<div id=contentoperation><label>Visit No.: </label> <input
	type="text" name="<%=VISIT_NUMBER %>" value="" class="textbox_size20"
	validate="Visit No. , number,no" MAXLENGTH="20" readonly="readonly">


<label> ED Days</label> <input type="text" name="<%=NO_OF_DAYS%>"
	value="" class="textbox_size20" validate="No. of days , number,no"
	MAXLENGTH="5" onchange="calculateEdDate();" /> <label>ED Date:
</label> <input type="text" name="<%=DATE_OF_ED%>" value=""
	class="textbox_size20" validate="Date of ED" MAXLENGTH="30" /> <label>Dispose
:</label> <select id="disposalId" name="<%=DISPOSAL_ID %>">
	<option value="0">Select</option>
	<%
								for (MasDisposal masDisposal : disposalList) {
							%>
	<option value="<%=masDisposal.getId() %>"><%=masDisposal.getDisposalName()%></option>
	<%
							}
						%>
</select>



<div id="edited"></div>
<label>&nbsp;</label> <input type="hidden" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('occupation','generalMaster?method=addOccupation');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('EDReturns','mis?method=editEDReturns')"
	accesskey="u" tabindex=1 /> <input type="hidden" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('occupation','generalMaster?method=deleteOccupation')"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	value="Reset" class="button" onclick="location.reload();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" id="visitID" name="<%=VISIT_ID%>" value="" /></div>
</div>

<script type="text/javascript">
				data_header = new Array();
				
				data_header[0] = new Array;
				data_header[0][0] = "Rank"
				data_header[0][1] = "data";
				data_header[0][2] = "25%";
				data_header[0][3] = "<%= RANK_ID%>"
				
				data_header[1] = new Array;
				data_header[1][0] = "Name"
				data_header[1][1] = "data";
				data_header[1][2] = "40%";
				data_header[1][3] = "<%= PATIENT_NAME%>";
				
				data_header[2] = new Array;
				data_header[2][0] = "Trade"
				data_header[2][1] = "data";
				data_header[2][2] = "40%";
				data_header[2][3] = "<%=TRADE_ID%>";
				
				data_header[3] = new Array;
				data_header[3][0] = "Visit No."
				data_header[3][1] = "hide";
				data_header[3][2] = "40%";
				data_header[3][3] = "<%=VISIT_NUMBER%>";
				
				data_header[4] = new Array;
				data_header[4][0] = "Visit Date"
				data_header[4][1] = "data";
				data_header[4][2] = "40%";
				data_header[4][3] = "<%=VISIT_DATE%>";
				
				data_header[5] = new Array;
				data_header[5][0] = "Unit"
				data_header[5][1] = "data";
				data_header[5][2] = "40%";
				data_header[5][3] = "<%=UNIT_ID%>";
				
				data_header[6] = new Array;
				data_header[6][0] = "No. of days"
				data_header[6][1] = "data";
				data_header[6][2] = "40%";
				data_header[6][3] = "<%=NO_OF_DAYS%>";
				
				data_header[7] = new Array;
				data_header[7][0] = "Date of ED"
				data_header[7][1] = "data";
				data_header[7][2] = "40%";
				data_header[7][3] = "<%=DATE_OF_ED%>";
				
				data_header[8] = new Array;
				data_header[8][0] = "Dispose"
				data_header[8][1] = "data";
				data_header[8][2] = "40%";
				data_header[8][3] = "<%=DISPOSAL_ID%>";
				
				data_header[9] = new Array;
				data_header[9][0] = "Status"
				data_header[9][1] = "data";
				data_header[9][2] = "15%";
				data_header[9][3] = "<%=STATUS %>";
				
				data_arr = new Array();
				category=document.getElementById('categoryId').value
				<%
				if(list!=null){
				int counter=0;
				Iterator ite = list.iterator();
				while ( ite.hasNext() ) {
			         Object[] pair = (Object[]) ite.next();
			         Visit visit = (Visit) pair[0];
			         Patient patient = (Patient) pair[1];
			         MasRank masRank=(MasRank) pair[2];
			         MasRankCategory masRankCategory=(MasRankCategory) pair[3];
			         MasTrade masTrade=(MasTrade) pair[4];
			         MasUnit masUnit=(MasUnit) pair[5];
			         MasDisposal masDisposal=(MasDisposal)pair[6];
						
			      
					
					//	int counter=0;
				       // for(Visit visit:list){
				          
				%>			
						  	data_arr[<%= counter%>] = new Array();
							data_arr[<%= counter%>][0] = <%=visit.getId()%>
							<%if( masRank.getId()!=null){%>
							
								data_arr[<%= counter%>][1] = "<%=masRank.getRankName()%>"
							<%}
							else{%>
								data_arr[<%= counter%>][1] = ""
							<%}%>
							data_arr[<%= counter%>][2] = "<%= patient.getPFirstName()%> <%= patient.getPMiddleName()%> <%= patient.getPLastName()%>"
							
							<%if( patient.getTrade()!=null){%>
								data_arr[<%= counter%>][3] = "<%= masTrade.getTradeName()%>"
							
							<%}else{%>
								data_arr[<%= counter%>][3] = " "
							<%}%>
							data_arr[<%= counter%>][4] = "<%= visit.getVisitNo() %>"
							data_arr[<%= counter%>][5] = "<%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate())%>"
							<%if( patient.getUnit()!=null){%>
								
								data_arr[<%= counter%>][6] = "<%= masUnit.getUnitName()%>"
							<%}
							else{%>
								data_arr[<%= counter%>][6] = " "
							<%}
							if(visit.getEdDays()!=null){
							%>
									data_arr[<%= counter%>][7] = "<%= visit.getEdDays()%>"
							<%}
							else{%>
									data_arr[<%= counter%>][7] = " "
							<%}
							if(visit.getEdDate()!=null){
							%>
									data_arr[<%= counter%>][8] = "<%=HMSUtil.convertDateToStringWithoutTime(visit.getEdDate())%>"
							<%}
							else{%>
									data_arr[<%= counter%>][8] = " "
							<%}
							if(visit.getEdDispose()!=null){
							%>
									data_arr[<%= counter%>][9] = "<%= visit.getEdDispose()%>"
						<%	}
							else{
							%>
									data_arr[<%= counter%>][9] = " "
							<%}
							if(visit.getEdStatus()!=null){
							%>	
									data_arr[<%= counter%>][10] = "<%= visit.getEdStatus()%>"
							<%}
							else{%>
									data_arr[<%= counter%>][10] = " "
							<%}%>
				<%
				counter++;
					 }	
					 
					}
					
				%>
				formName = "EDReturns"

				start = 0
				if(data_arr.length < rowsPerPage)
					end = data_arr.length;
				else
					end = rowsPerPage;
				makeTable(start,end);
				
				intializeHover('searchresulttable', 'TR', ' tableover');		
				</script>




<br />
<br />

</form>
</div>





