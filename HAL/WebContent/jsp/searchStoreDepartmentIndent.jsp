<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * searchStoreDepartmentIndent.jsp  
 * Purpose of the JSP -  This is Search for store department indent.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 05th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		</script>
<%		List<StoreInternalIndentM> searchStoreInternalIndentMList= new ArrayList<StoreInternalIndentM>();
		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	
		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(dateOfMonth);
		} else {
			orderDateOnly.append(dateOfMonth);
		}
	
		orderDateOnly.append("/");
	
		int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month);
		} else {
			orderDateOnly.append(month);
		}
	
		orderDateOnly.append("/");
		int year = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year);
		String currentDate = new String(orderDateOnly);
	%>
<%	
	Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreInternalIndentM> gridIndentHeaderList= new ArrayList<StoreInternalIndentM>();
		
		try{
			gridIndentHeaderList=(List)map.get("indentHeaderList");
			searchStoreInternalIndentMList=(List)map.get("searchStoreInternalIndentMList");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ArrayList gridSectionList = (ArrayList)map.get("sectionList");
		ArrayList gridApprovedByList = (ArrayList)map.get("approvedByList");
		ArrayList gridRequestedByList = (ArrayList)map.get("requestByList");
		ArrayList gridDepartmentList = (ArrayList)map.get("departmentList");
			
		
	%>

<div id="contentspace"><br />

<form name="searchDeparmentIndent" method="post" action="">


<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>


		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton"
					onClick="submitForm('searchDeparmentIndent','stores?method=showDepartmentIndentJsp');" /></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" value="Modify" class="toolbutton"
					onClick="submitForm('searchDeparmentIndent','stores?method=modifyDeparmentIndent','validateRadio');" /></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					name="Reset" type="reset" value="Reset" class="toolbutton"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="print" type="submit" class="toolbutton"
					value=" " onClick=""></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form action="searchPanel" method="post">
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.searchDeparmentIndent.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.searchDeparmentIndent.<%= TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Demand No:</label> <select
			name="<%= SEARCH_DEMAND_NO%>">
			<option value="0">Select</option>
			<%
							for (StoreInternalIndentM storeInternalIndentM :searchStoreInternalIndentMList ) {
						%>

			<option value=<%=storeInternalIndentM.getDemandNo()%>><%=storeInternalIndentM.getDemandNo()%></option>

			<%
							}
						%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('searchDeparmentIndent','stores?method=searchDepartmentIndent');" />
		</td>
	</tr>

</table>
</form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



</div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>
<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= DEPARTMENT_INDENT_ID%>", "id"],[1, "<%= DEMAND_NO%>"], [2,"<%= DEMAND_DATE%>"], [3,"<%= FORM_STORE_DEPT_WARD_DEPARTMENT_ID_DEPENDENT_INDENT %>"], [4,"<%= APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT %>"], [5,"<%= SECTION_ID_DEPENDENT_INDENT %>"],[6,"<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"] ];
	 statusTd =6;

</script>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Demand No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= DEMAND_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Demand Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= DEMAND_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "From store/Dept./Ward"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=FORM_STORE_DEPT_WARD_DEPARTMENT_ID_DEPENDENT_INDENT %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Approved By"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT %>";
		
		
		data_header[5] = new Array;
		data_header[5][0] = "To Store By"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=SECTION_ID_DEPENDENT_INDENT %>";
	
		data_header[6] = new Array;
		data_header[6][0] = "Request By"
		data_header[6][1] = "data";
		data_header[6][2] = "15%";
		data_header[6][3] = "<%=REQUEST_BY_EMPLOYEE_ID_DEPENDENT_INDENT %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridIndentHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreInternalIndentM  storeInternalIndentM = (StoreInternalIndentM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeInternalIndentM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeInternalIndentM.getId()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeInternalIndentM.getDemandNo()%>"
			data_arr[<%= counter%>][3]= "<%= HMSUtil.changeDateToddMMyyyy(storeInternalIndentM.getDemandDate())%>"
			
			
			
			           
 <%
		Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {try{
             MasDepartment  departmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
			 if(storeInternalIndentM.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=departmentGrid.getDepartmentName()%>"
			<%}else if(storeInternalIndentM.getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=departmentGrid.getDepartmentName()%>";
				
			<%}
            }catch(Exception e){

            e.printStackTrace();
            }}%>
            
            
            
             <%
		Iterator itrGridApprovedByList=gridApprovedByList.iterator();
		 while(itrGridApprovedByList.hasNext())
            {try{
             MasEmployee  approvedByGrid = (MasEmployee)itrGridApprovedByList.next(); 
			 if(storeInternalIndentM.getApprovedBy().getId().equals(approvedByGrid.getId()) && approvedByGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=approvedByGrid.getId()%>"
			<%}else if(storeInternalIndentM.getId().equals(approvedByGrid.getId()) && approvedByGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=approvedByGrid.getId()%>";
				
			<%}
            }catch(Exception e){
            	e.printStackTrace();
            	
            }}%>
            
                    		           
 <%
		Iterator itrGridSectionList=gridSectionList.iterator();
		 while(itrGridSectionList.hasNext())
            {try{
             MasStoreSection  sectionGrid = (MasStoreSection)itrGridSectionList.next(); 
			 if(storeInternalIndentM.getToStore().getId().equals(sectionGrid.getId()) && sectionGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][6] = "<%=sectionGrid.getSectionName()%>"
			<%}else if(storeInternalIndentM.getId().equals(sectionGrid.getId()) && sectionGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=sectionGrid.getSectionName()%>";
				
			<%}
            }catch(Exception e){
            	e.printStackTrace();
            	
            }}%>
            
            
            
            
            
             <%
		Iterator itrGridRequestedByList=gridRequestedByList.iterator();
		 while(itrGridRequestedByList.hasNext())
            {try{
             MasEmployee  requestedByGrid = (MasEmployee)itrGridRequestedByList.next(); 
			 if(storeInternalIndentM.getRequestedBy().getId().equals(requestedByGrid.getId()) && requestedByGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][7] = "<%=requestedByGrid.getId()%>"
			<%}else if(storeInternalIndentM.getId().equals(requestedByGrid.getId()) && requestedByGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=requestedByGrid.getId()%>";
				
			<%}
            }catch(Exception e){
				e.printStackTrace();
            }}%>
            
            
            
			
			
		<% counter++;
			}
		%>
		 
		formName = "searchDeparmentIndent"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
</form>