<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdEquipmentMst.jsp  
 * Purpose of the JSP -  This is for All Equipment Master.
 * @author  Vishal Jain
 * Create Date: 18,Auguast 2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.AppEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

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




<%
Map<String,Object> map = new HashMap<String,Object>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchOpdEquipmentList = (ArrayList)map.get("searchOpdEquipmentList");
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
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
		  <h4><span><%=message %></span></h4>
		 
		 <% }%>
<div class="titleBg">
<h2>Opd Equipment</h2>
</div>
<div class="clear"></div>
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">
<label>Equipment Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radio" />
<label>Equipment Name</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" class="radio" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Equipment Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'opdMaster?method=searchOpdEquipment')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','opdMaster?method=searchOpdEquipment','checkSearch')"	tabindex=1 />
<input type="button" name="report"	value="Generate Report" class="buttonBig"	onclick="submitForm('search','opdMaster?method=generateReportForOpdEquipment')"	tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>"	value="EquipmentMaster">
</div>
</form>
</div>
</div>
<div class="clear"></div>


<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
 	
		if(searchOpdEquipmentList.size()>0)
		 {
			
			String strForCode = (String)map.get("equipmentCode");
			String strForCodeDescription = (String)map.get("equipmentName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
				
	%> 
<h4><a href="opdMaster?method=showOpdEquipmentJsp">Show All Records</a></h4> <%
			}
		 }
		
	 if(searchOpdEquipmentList.size()==0 && map.get("search") != null)
	  {
		 
	 %> <h4><a href="opdMaster?method=showOpdEquipmentJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= NO_OF_EQUIPMENT%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"],[8,"<%=DEPARTMENT_ID%>"] ];
	 statusTd = 7;
	</script>
	</div>

<div class="clear"></div>
<form name="opdEquipment" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="AppEquipmentMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="EquipmentName">
<input type="hidden" name="title"	value="OpdEquipment">
<input type="hidden"	name="<%=JSP_NAME %>" value="opdEquipmentMst">
<input	type="hidden" name="pojoPropertyCode" value="EquipmentCode">
<div class="clear"></div>
<div class="Block">
<label> Equipment Code  <span>*</span></label>
<input id="codeId" type="text"	name="<%= CODE%>" value="" validate="Equipment Code,string,yes"	MAXLENGTH="8" tabindex=1 />
<label> Equipment Name <span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Equipment Name,string,yes" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'opdMaster?method=addOpdEquipment')" />
<script>
			document.opdEquipment.<%=CODE%>.focus();
		</script>
<label>No of Equipment <span>*</span></label>
<input	type="text" name="<%=NO_OF_EQUIPMENT%>" value="" validate="No of Equipments,int,yes" MAXLENGTH="3" />
<div class="clear"></div>
<label> Department <span>*</span> </label>
<select	id="departmentId" name="<%=DEPARTMENT_ID%>"	validate="Department,number,yes">
	<option value="0">Select</option>
	<%
				int deptId=(Integer)session.getAttribute("deptId");
				if(departmentList!= null){
				for (MasDepartment masDepartment : departmentList) {
					if(masDepartment.getId()==deptId){
			%>
	<option value="<%=masDepartment.getId()%>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%	
					}
				}
			}
			%>
</select>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('opdEquipment','opdMaster?method=addOpdEquipment');"	accesskey="a" tabindex=1/>
<input type="button" name="edit"	id="editbutton" value="Update" class="button"	onClick="submitForm('opdEquipment','opdMaster?method=editOpdEquipment')"	accesskey="u" tabindex=1/>
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button"	onClick="submitForm('opdEquipment','opdMaster?method=deleteOpdEquipment&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label	class="value"><%=userName %></label>
<label>Changed Date</label>
<label	class="value"><%=date%></label>
<label>Changed Time</label>
<label	class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="clear"></div>
</div>

</form>


<script type="text/javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Equipment Code"
		data_header[0][1] = "data";
		data_header[0][2] = "25%";
		data_header[0][3] = "<%= CODE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Equipment Name"
		data_header[1][1] = "data";
		data_header[1][2] = "40%";
		data_header[1][3] = "<%= SEARCH_NAME %>";
		
		data_header[2] = new Array;
		data_header[2][0] = "No of Equipment"
		data_header[2][1] = "data";
		data_header[2][2] = "40%";
		data_header[2][3] = "<%= NO_OF_EQUIPMENT %>";
		
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

		data_header[7] = new Array;
		data_header[7][0] = "Department"
		data_header[7][1] = "hide";
		data_header[7][2] = "40%";
		data_header[7][3] = "<%= DEPARTMENT_ID %>";
		
		data_arr = new Array();

	<%
	
	  
	Iterator itr = searchOpdEquipmentList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	             AppEquipmentMaster appEquipmentMaster = (AppEquipmentMaster)itr.next(); 
	%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] =  <%= appEquipmentMaster.getId()%>
		data_arr[<%= counter%>][1] = "<%= appEquipmentMaster.getEquipmentCode()%>"
		data_arr[<%= counter%>][2] = "<%= appEquipmentMaster.getEquipmentName()%>"
		data_arr[<%= counter%>][3] = "<%= appEquipmentMaster.getNoOfEquipments()%>"
		data_arr[<%= counter%>][4] = "<%= appEquipmentMaster.getLastChgBy() %>"
		data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(appEquipmentMaster.getLastChgDate())%>"
		data_arr[<%= counter%>][6] = "<%= appEquipmentMaster.getLastChgTime() %>"
		<% if(appEquipmentMaster.getEquipmentStatus().equalsIgnoreCase("y")){ %>
		data_arr[<%= counter%>][7] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][7] = "InActive"
		<%}%>
		<%
	
	 for(MasDepartment department : departmentList )
           {
		 
		 if(appEquipmentMaster.getDepartment().getId().equals(department.getId()) && department.getStatus().equals("y")){%>
			data_arr[<%= counter%>][8] = "<%=department.getDepartmentName()%>"
		<%}else if(appEquipmentMaster.getDepartment().getId().equals(department.getId()) && department.getStatus().equals("n")){%>
			data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=department.getDepartmentName()%>";
			
		<%}
}%>
		
		
		
		<%
				     counter++;
		}
		%>
 
		formName = "opdEquipment"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
		</script>
