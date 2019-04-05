<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * bed.jsp  
 * Purpose of the JSP -  This is for Bed Details.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.10  
--%>

<%@page import="jkt.hms.masters.business.OtBed"%>
<%@page import="jkt.hms.masters.business.MasOt"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasBedStatus"%>
<%@page import="jkt.hms.masters.business.Department"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<%	
		Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String,Object>) request.getAttribute("map");
		}		
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = (ArrayList)map.get("departmentList");
		
		List<MasBedStatus> bedStatusList = new ArrayList<MasBedStatus>();
		bedStatusList = (ArrayList)map.get("bedStatusList");

	
		List<MasDepartment> departmentListGrid = new ArrayList<MasDepartment>();
		departmentListGrid = (ArrayList)map.get("departmentListGrid");
		
		List<MasBedStatus> bedStatusListGrid = new ArrayList<MasBedStatus>();
		bedStatusListGrid = (ArrayList)map.get("bedStatusListGrid");
		
		List<MasOt> otListGrid = new ArrayList<MasOt>();
		otListGrid = (ArrayList)map.get("otListGrid");
		
		
		
		List<OtBed> searchOtBedList = (ArrayList)map.get("searchOtBedList");
				
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   %>
			   <h4><%=message %></h4>
			   <%}%>

<div class="titleBg">
<h2>OT Table Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Table Number</label>
<input type="text" id="searchField" name="<%=SEARCH_NAME%>"	value="" validate="Table Number,string,no" MAXLENGTH="8"	onkeypress="return submitenter(this,event,'hospital?method=searchOt')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','hospital?method=searchOt','checkSearch')" tabindex=1 /> <%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report"	class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="OtTable">
</form>
</div>
</div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults">
<div id="searchtable"></div>

<%
	try
	{
		if(searchOtBedList != null)
		{
			if(searchOtBedList.size()>0 )
		 	{
				String strForCode = (String)map.get("bedNumber");
				if(strForCode!= null && strForCode!= "")
				{
%>
				<h4><a href="hospital?method=showOtJsp">Show All Records</a></h4>
<%
			}
		 }
		 if(searchOtBedList.size()==0 && map.get("search") != null)
	  	 {
%>
				<h4><a href="hospital?method=showOtJsp">Show All Records</a></h4> 
<%
      	}
	}
}
catch(Exception ex)
{
 	  ex.printStackTrace();
}
%>
 	<script type="text/javascript">
	
	formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"<%= BED_STATUS_ID%>"],[3,"<%= DEPARTMENT_ID%>"],[4,"<%= AD_NO%>"],[5,"<%= DIET_TYPE%>"],[6,"<%= ATTACHED%>"],[7,"<%= INTRODUCTION_DATE%>"], [8,"<%= DISCARD_DATE%>"] ,[9,"<%= CHANGED_BY%>"] ,[10,"<%= CHANGED_DATE%>"] ,[11,"<%= CHANGED_TIME%>"] ,[12,"<%=OT_ID%>"],[13,"<%=STATUS%>"]];
		
	 statusTd = 13;
	</script></div>

<form name="bed" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="<%= POJO_NAME %>" value="MasBed"><input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="BedNo"><input
	type="hidden" name="title" value="Bed"><input type="hidden"
	name="<%=JSP_NAME %>" value="bed"><input type="hidden"
	name="pojoPropertyName" value="BedNumber"><input type="hidden"
	name="pojoPropertyCode" value="Department.Id">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Table Number</label>
<input id="codeId" type="text"	name="<%= SEARCH_NAME%>" value="" validate="Table Number,string,yes" MAXLENGTH="8" />
<script>
			document.bed.<%=SEARCH_NAME%>.focus();
		</script>
<label><span>*</span> Department</label>
<select name="<%=DEPARTMENT_ID %>" validate="Deparment,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(departmentList != null)
          		{
          			for(MasDepartment masDepartment : departmentList)
          			{
          %>
					<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName() %></option>
		  <%		
         			}
         		 } 
         %>
</select>

<label><span>*</span> OT </label>
<select name="<%=OT_ID %>" validate="OT,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(otListGrid != null)
          		{
          			for(MasOt masOt : otListGrid)
          			{
          %>
					<option value="<%=masOt.getId()%>"><%=masOt.getOtName() %></option>
		  <%		
         			}
         		 } 
         %>
</select>

<div class="clear"></div>
<label><span>*</span> Bed Status </label>
<select name="<%=BED_STATUS_ID%>"	validate="Bed Status,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(bedStatusList != null){ 	
          			for (Iterator iter = bedStatusList.iterator(); iter.hasNext();) {
          				MasBedStatus masBedStatus = (MasBedStatus) iter.next();
          %>
	<option value="<%=masBedStatus.getId() %>"><%=masBedStatus.getBedStatusName() %></option>
	<%		
          			} }
         %>
</select>
<div style="display: none;">
<label>IP No. </label>
<input type="text"	name="<%= AD_NO%>" value="" validate="IP No.,string,no"	readonly="readonly" class="readonly" MAXLENGTH="8" />
<label><span>*</span> Diet Type </label>
<select
	name="<%=DIET_TYPE%>">
	<option value="0">Select</option>
	<option value="Veg">Veg</option>
	<option value="Non-Veg">Non-Veg</option>
</select>
<div class="clear"></div>
<label>Attached</label>
<input type="checkbox" class="radioCheck"	name="<%=ATTACHED %>" value="y"	>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('bed','hospital?method=addOt');" accesskey="a" />
	<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('bed','hospital?method=editOt')" accesskey="u" />
	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('bed','hospital?method=deleteOt&flag='+this.value)" accesskey="d" />
	<input type="reset" name="Reset" id="reset" value="Reset" class="addbutton" onclick="resetCheck();" accesskey="r" />
	<input type="hidden" name="<%=STATUS %>" value="" />
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
	
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>

	<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Table Number"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= SEARCH_NAME %>"

data_header[1] = new Array;
data_header[1][0] = "Bed Status"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= BED_STATUS_ID%>"

data_header[2] = new Array;
data_header[2][0] = "Department"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= DEPARTMENT_ID %>"


data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= AD_NO %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= DIET_TYPE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=ATTACHED %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=INTRODUCTION_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=DISCARD_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_BY %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_DATE %>"

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=CHANGED_TIME %>"

	data_header[11] = new Array;
data_header[11][0] = "OT"
data_header[11][1] = "data";
data_header[11][2] = 0;
data_header[11][3] = "<%=OT_ID %>"

data_header[12] = new Array;
data_header[12][0] = "Status"
data_header[12][1] = "data";
data_header[12][2] = 0;
data_header[12][3] = "<%=STATUS %>"




data_arr = new Array();

<%
int  counter=0;

for (OtBed otBed : searchOtBedList){
	

%>

data_arr[<%= counter%>] = new Array();

data_arr[<%= counter%>][0] = "<%=otBed.getBed().getId()%>"
data_arr[<%= counter%>][1] = "<%=otBed.getBed().getBedNo()%>"
	
	
<%

	Iterator itrBedStatusList=bedStatusListGrid.iterator();
	 while(itrBedStatusList.hasNext())
           {
            MasBedStatus  masBedStatusGrid = (MasBedStatus)itrBedStatusList.next(); 
		 if(otBed.getBed().getBedStatus().getId().equals(masBedStatusGrid.getId()) && masBedStatusGrid.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][2] = "<%=masBedStatusGrid.getBedStatusName()%>"
		<%}else if(otBed.getBed().getBedStatus().getId().equals(masBedStatusGrid.getId()) && masBedStatusGrid.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masBedStatusGrid.getBedStatusName()%>";			
		<%}
}%>
<%
	Iterator itrDepartmentList=departmentListGrid.iterator();
	 while(itrDepartmentList.hasNext())
           {
		 	MasDepartment masDepartmentGrid = (MasDepartment) itrDepartmentList.next();
		 if(otBed.getBed().getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][3] = "<%=masDepartmentGrid.getDepartmentName()%>"
		<%}else if(otBed.getBed().getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masDepartmentGrid.getDepartmentName()%>";
		<%}
}%>







data_arr[<%= counter%>][4] = "<%=otBed.getBed().getAdNo()%>"
data_arr[<%= counter%>][5] = "<%=otBed.getBed().getDietType()%>"
data_arr[<%= counter%>][6] = "<%=otBed.getBed().getAttached()%>"
data_arr[<%= counter%>][7] = "<%=otBed.getBed().getIntroductionDate()%>"
data_arr[<%= counter%>][8] = "<%=otBed.getBed().getDiscardDate()%>"
data_arr[<%= counter%>][9] = "<%= otBed.getBed().getLastChgBy()!=null?otBed.getBed().getLastChgBy().getId():"" %>"
data_arr[<%= counter%>][10] = "<%= HMSUtil.changeDateToddMMyyyy(otBed.getBed().getLastChgDate()) %>"
data_arr[<%= counter%>][11] = "<%= otBed.getBed().getLastChgTime() %>"
	<%
	Iterator itrOTList=otListGrid.iterator();
	 while(itrOTList.hasNext())
	       {
		 	MasOt masOtGrid = (MasOt) itrOTList.next();
		 if(otBed.getOt().getId().equals(masOtGrid.getId()) && masOtGrid.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][12] = "<%=masOtGrid.getOtName()%>"
		<%}else if(otBed.getOt().getId().equals(masOtGrid.getId()) && masOtGrid.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][12] = "<font id='error'>*</font>Parent InActivated--<%=masOtGrid.getOtName()%>";
		<%}
	       }%> 
<% if(otBed.getBed().getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][13] = "Active"
<%}else{%>
data_arr[<%= counter%>][13] = "InActive"
<%}%>



<%
		   counter++;
}
%>
formName = "bed"

nonEditable = ['<%= SEARCH_NAME%>']
nonEditable = ['<%= AD_NO%>']
 
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	
	
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>
