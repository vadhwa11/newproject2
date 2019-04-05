<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * hospital.jsp  
	 * Purpose of the JSP -  This is for All Hospital Master.
	 * @author  Mansi
	 * Create Date: 04 June,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.5
	--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasButtonForm"%>
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
	ArrayList searchButtonDetailsList = (ArrayList)map.get("searchButtonDetailsList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	
	
	%> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %> <h4> <span><%=message %> </span></h4> <%
		}
    %>
<div class="titleBg">
<h2>Button Details Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Button Name</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioAuto" /> 
<label>Form Name</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" class="radioAuto" value="2" /> 
<input	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="Hospital Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'user?method=')" /> 
<input	type="button" name="search" value="Search" class="button"	onclick="submitForm('search','user?method=','checkSearch')" tabindex=1 />
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
			if(searchButtonDetailsList.size()>0)
			 {
				String strForCode = (String)map.get("hospitalCode");
				String strForCodeDescription = (String)map.get("hospitalName");
				if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
				{
		%>


<h4><a href="user?method=showButtonMasterJsp">Show All Records</a></h4>
<%
				}
			 }
		 if(searchButtonDetailsList.size()==0 && map.get("search") != null)
		  {
		 %>
<h4><a href="user?method=showButtonMasterJsp">Show All Records</a></h4>
<%
	     }
		%> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"url"], [4,"<%= CONTACT_NUMBER %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
		 statusTd = 8;
		</script></div>
<div class="Clear paddingTop15"></div>
<form name="buttonDetails" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasButtonForm"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FormName">
<input type="hidden" name="title" value="Hospital"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="buttonForm"> 
<input	type="hidden" name="pojoPropertyCode" value="ButtonName">
<div class="Block">
<label><span>*</span> Button Name </label> 
<input id="codeId" type="text" name="<%= CODE%>" value=""	validate="Button Name,string,yes" MAXLENGTH="30" tabindex=1 /> 
<label><span>*</span> Form Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Form Name,string,yes" MAXLENGTH="40" tabindex=1 /> 
<script>
					buttonDetails.buttonDetails.<%=CODE%>.focus();
					</script> 
<label><span>*</span> Css Class Name </label> 
<input	id="cssClass" type="text" name="cssClass" value="" validate="CSS Class Name,string,yes" MAXLENGTH="30" tabindex=1 />
<div class="Clear"></div>
<label>Formula Used </label> 
<input id="formulaUsed" type="text"	name="formulaUsed" value="" MAXLENGTH="30" tabindex=1 /> 
<label><span>*</span> URL</label> 
<input type="text" name="url" value="" validate="URL,string,yes"	class="large" MAXLENGTH="100" tabindex=1 />
</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('buttonDetails','user?method=addButtonDetails');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('buttonDetails','user?method=editButtonDetails')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('buttonDetails','user?method=deleteButtonDetails&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="Back" value="Back" class="button"
	accesskey="b"
	onclick="submitFormForButton('buttonDetails','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="admin" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="Clear"></div>
</form>


<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Button Name"
	data_header[0][1] = "data";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Form Name"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= SEARCH_NAME %>";
	
	
	
	data_header[2] = new Array;
	data_header[2][0] = "URL"
	data_header[2][1] = "hide";
	data_header[2][2] = "25%";
	data_header[2][3] = "url"
	
	data_header[3] = new Array;
	data_header[3][0] = ""
	data_header[3][1] = "hide";
	data_header[3][2] = "40%";
	data_header[3][3] = "";
	
	
	
	data_header[4] = new Array;
	data_header[4][0] = ""
	data_header[4][1] = "hide";
	data_header[4][2] = 0;
	data_header[4][3] = "<%= CHANGED_BY%>"
	
	data_header[5] = new Array;
	data_header[5][0] = ""
	data_header[5][1] = "hide";
	data_header[5][2] = 0;
	data_header[5][3] = "<%= CHANGED_DATE%>"
	
	data_header[6] = new Array;
	data_header[6][0] = ""
	data_header[6][1] = "hide";
	data_header[6][2] = "15%";
	data_header[6][3] = "<%=CHANGED_TIME %>";
	
	
	data_header[7] = new Array;
	data_header[7][0] = "Status"
	data_header[7][1] = "data";
	data_header[7][2] = "15%";
	data_header[7][3] = "<%=STATUS %>";
	
	data_arr = new Array();
	
	<%
	Iterator itr=searchButtonDetailsList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	             MasButtonForm  masButtonForm = (MasButtonForm)itr.next(); 
	
	%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= masButtonForm.getId()%>
	data_arr[<%= counter%>][1] = "<%= masButtonForm.getButtonName()%>"
	data_arr[<%= counter%>][2] = "<%= masButtonForm.getFormName()%>"
	
	data_arr[<%= counter%>][3] = "<%= masButtonForm.getUrl()%>"
	data_arr[<%= counter%>][4] = "<%= masButtonForm.getStatus()%>"
	
	data_arr[<%= counter%>][5] = "<%= masButtonForm.getLastChgBy() %>"
	data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masButtonForm.getLastChgDate()) %>"
	data_arr[<%= counter%>][7] = "<%= masButtonForm.getLastChgTime() %>"
	<% if(masButtonForm.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][8] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][8] = "InActive"
	<%}%>
	<%
			     counter++;
	}
	%>
	 
	formName = "buttonDetails"
	
	//nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>
