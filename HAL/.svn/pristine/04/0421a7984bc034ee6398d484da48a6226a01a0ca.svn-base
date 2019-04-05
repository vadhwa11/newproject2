<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * searchMmfDepartment.jsp  
 * Purpose of the JSP -  This is for Search of MMF Department.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 15th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreMmfDepartmentM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
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
<%		List<StoreMmfDepartmentM> searchStoreMmfDepartmentMList= new ArrayList<StoreMmfDepartmentM>();
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
		List<StoreMmfDepartmentM> gridIndentHeaderList= new ArrayList<StoreMmfDepartmentM>();
		
		try{
			gridIndentHeaderList=(List)map.get("indentHeaderList");
			searchStoreMmfDepartmentMList=(List)map.get("searchStoreMmfDepartmentMList");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ArrayList gridApprovedByList = (ArrayList)map.get("approvedByList");
		ArrayList gridDepartmentList = (ArrayList)map.get("departmentList");
			
		
	%>

<div id="contentspace"><br />

<form name="searchMmfDeparment" method="post" action="">


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
					onClick="submitForm('searchMmfDeparment','stores?method=showMmfDepartmentJsp');" /></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" value="Modify" class="toolbutton"
					onClick="submitForm('searchMmfDeparment','stores?method=modifyMmfDeparment','validateRadio');" /></td>
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
			onClick="setdate('<%=currentDate%>',document.searchMmfDeparment.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.searchMmfDeparment.<%= TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Store/Dept/Ward Name:</label> <select
			name="<%= SEARCH_STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT%>">
			<option value="0">Select</option>
			<%
					for (StoreMmfDepartmentM storeMmfDepartmentM :searchStoreMmfDepartmentMList ) {
				%>

			<option value=<%=storeMmfDepartmentM.getStoreWardDept().getId()%>><%=storeMmfDepartmentM.getStoreWardDept().getDepartmentName()%></option>

			<%
					}
				%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('mmfDepartment','stores?method=searchMmfDepartment');" />
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
			[0, "<%= MMF_DEPARTMENT_M_ID%>", "id"],[1, "<%= DOC_NO%>"], [2,"<%= MMF_DEPARTMENT_DATE%>"], [3,"<%= STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT %>"], [4,"<%= APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT %>"],[5,"<%=REMARKS%>"] ];
	 statusTd =5;

</script>
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Doc No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= DOC_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "MMF For Year"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= MMF_DEPARTMENT_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "From store/Dept./Ward"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=STORE_DEPT_WARD_DEPARTMENT_ID_MMF_DEPENDENT %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Approved By"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=APPROVED_BY_EMPLOYEE_ID_MMF_DEPENDENT %>";
		
		
		data_header[5] = new Array;
		data_header[5][0] = "Remarks"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=REMARKS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridIndentHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreMmfDepartmentM  storeMmfDepartmentM = (StoreMmfDepartmentM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeMmfDepartmentM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeMmfDepartmentM.getId()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeMmfDepartmentM.getDocNo()%>"
			data_arr[<%= counter%>][3]= "<%= storeMmfDepartmentM.getMmfForTheYear()%>"
			
			           
 <%
		Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {try{
             MasDepartment  departmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
			 if(storeMmfDepartmentM.getStoreWardDept().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=departmentGrid.getDepartmentName()%>"
			<%}else if(storeMmfDepartmentM.getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("n")){%>
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
			 if(storeMmfDepartmentM.getApprovedBy().getId().equals(approvedByGrid.getId()) && approvedByGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=approvedByGrid.getId()%>"
			<%}else if(storeMmfDepartmentM.getId().equals(approvedByGrid.getId()) && approvedByGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=approvedByGrid.getId()%>";
				
			<%}
            }catch(Exception e){
            	e.printStackTrace();
            	
            }}%>
            
   
            
            	data_arr[<%= counter%>][6] = "<%=storeMmfDepartmentM.getRemarks()%>"
            
			
			
		<% counter++;
			}
		%>
		 
		formName = "searchMmfDeparment"
		
		
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