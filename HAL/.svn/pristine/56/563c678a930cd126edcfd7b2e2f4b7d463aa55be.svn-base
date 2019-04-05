
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * department.jsp  
	 * Purpose of the JSP -  This is for Department details 
	 * @author  Dipali
	 * @author  Mansi
	 * Create Date: 07th Feb,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.16
	--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<div id="contentHolder">
<%
		Map map = new HashMap();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		
		List<CommutationWeightage> searchCommutationList= new ArrayList<CommutationWeightage>(); 
		
		
		if(searchCommutationList!= null)
			searchCommutationList = (ArrayList)map.get("searchCommutationList");
		
		
		
		
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
	%>
<h6>Commutation Weightage Master</h6>
<div class="Clear"></div>
<%if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	%>
<div class="header">
<div id="searcharea">

<div id="searchbar">
<form name="search" method="post" action=""><label>Weightage
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" /> <label>Age</label> <input type="radio"
	class="radio" name="<%=SELECTED_RADIO %>" value="2" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Weightage Code,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','systemRelatedMaster?method=searchCommutationWeightage','checkSearch')"
	tabindex=1 /> <%--- <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=');" accesskey="g" tabindex=1/> 
	                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_department">
	                    --%></form>
</div>
</div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
			if(searchCommutationList.size()>0 )
			 {
				String strForCode = (String)map.get("weightageCode");
				int strForCodeDescription=0;
				if( map.get("age")!= null)
				 strForCodeDescription = (Integer)map.get("age");
				if(strForCode!= null && strForCode!= "" || strForCodeDescription != 0  )
				{
		%> <br />
<a href="systemRelatedMaster?method=showCommutationWeightageMasterJsp">Show
All Records</a> <%
				}
			 }
		if(searchCommutationList.size()==0 && map.get("search") != null)
		  {
	    %> <a
	href="systemRelatedMaster?method=showCommutationWeightageMasterJsp">Show
All Records</a> <%
	           }
	         %> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"age"], [3,"cmValue"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
		 statusTd = 7;
		</script></div>
<div class="Clear"></div>
<form name="commutation" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="CommutationWeightage">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value=""> <input
	type="hidden" name="title" value="Commutation Weightage"> <input
	type="hidden" name="<%=JSP_NAME %>" value="commutationWeightage">
<input type="hidden" name="pojoPropertyCode"
	value="CommutationWeightageCode">

<div class="blockFrame"><label><span>*</span> Weightage
Code</label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Weightage Code,string,yes" class="textbox_size20"
	MAXLENGTH="10" tabindex=1 /> <label><span>*</span> Age</label> <input
	type="text" name="age" value="" validate="Age,int,yes"
	class="textbox_size20" MAXLENGTH="2" tabindex=1 /> <script>
					document.department.<%=CODE%>.focus();
				</script> <label><span>*</span> CM Value</label> <input id="cmValue"
	type="text" name="cmValue" value="" validate="CM Value,float,yes"
	class="textbox_size20" MAXLENGTH="5" tabindex=1 /></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('commutation','systemRelatedMaster?method=addCommutationWeightageMaster');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('commutation','systemRelatedMaster?method=editCommutationWeightage')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('commutation','systemRelatedMaster?method=deleteCommutationWeightage&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</div>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Weightage Code"
	data_header[0][1] = "data";
	data_header[0][2] = "20%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Age"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "age";
	
	data_header[2] = new Array;
	data_header[2][0] = "CM Value"
	data_header[2][1] = "data";
	data_header[2][2] = "25%";
	data_header[2][3] = "cmValue"
	
	
	
	data_header[3] = new Array;
	data_header[3][0] = ""
	data_header[3][1] = "hide";
	data_header[3][2] = 0;
	data_header[3][3] = "<%=CHANGED_BY %>"
	
	data_header[4] = new Array;
	data_header[4][0] = ""
	data_header[4][1] = "hide";
	data_header[4][2] = 0;
	data_header[4][3] = "<%=CHANGED_DATE %>"
	
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
	    if(searchCommutationList!= null){
		Iterator itr=searchCommutationList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	            
	             CommutationWeightage  commutationWeightage = (CommutationWeightage)itr.next(); 
	
	%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= commutationWeightage.getId()%>
	data_arr[<%= counter%>][1] = "<%=commutationWeightage.getCommutationWeightageCode()%>"
	data_arr[<%= counter%>][2] = "<%= commutationWeightage.getAge()%>"
	
	data_arr[<%= counter%>][3] = "<%=commutationWeightage.getCmValue()%>";
	
	data_arr[<%= counter%>][4] = "<%= commutationWeightage.getLastChgBy() %>"
	data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(commutationWeightage.getLastChgDate()) %>"
	data_arr[<%= counter%>][6] = "<%= commutationWeightage.getLastChgTime() %>"
	
	<% if(commutationWeightage.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][7] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][7] = "InActive"
	<%}%>
	<%
			     counter++;
	}}
	%>
	 
	formName = "commutation"
	
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>
