<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * subCharge.jsp  
 * Purpose of the JSP -  This is for Sub Charge.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Fe0b,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@ page import="jkt.hms.masters.business.DiagParam"%>
<%@ page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
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
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<MasMainChargecode> mainChargeCodeList=new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeCodeList=new ArrayList<MasSubChargecode>();
	if(map.get("mainChargeCodeList") != null){
	mainChargeCodeList = (ArrayList)map.get("mainChargeCodeList");
	}
	if(map.get("subChargeCodeList") != null){
	subChargeCodeList = (ArrayList)map.get("subChargeCodeList");
	}
	ArrayList searchParamList = (ArrayList)map.get("searchParamList");
	ArrayList gridMainChargeList = (ArrayList)map.get("gridMainChargeList");
	ArrayList gridSubChargeList = (ArrayList) map.get("gridSubChargeList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
			%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>
<%} 
%>

<h2 align="left" class="style1">Diagnostic Parameter Master</h2>
<div id="searcharea">
<div class="search">
<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">SubCharge Code:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="bodytextB_blue">SubCharge
Name:</font> <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="SubCharge Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=searchDiagParam')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchDiagParam','checkSearch')"
	tabindex=1 /></form>
</div>
</div>
<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchParamList.size()>0 )
		 {
			String strForCode = (String)map.get("subChargecodeCode");
			String strForCodeDescription = (String)map.get("subChargecodeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <br />
<a href="hospital?method=showParamJsp">Show All Records</a> <%
			}
		 }
	if(searchParamList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="hospital?method=showParamJsp">Show All Records</a> <%
  }
	%> <script type="text/javascript">
	
	
	formFields = [
			[0, "<%= DIAG_ID%>", "id"], [1,"<%= SEQUENCE_NO%>"],[2,"<%= PREFIX%>"],[3,"<%= CRITERIA%>"],[4,"<%= MAIN_CHARGECODE_ID%>"],[5,"<%= SUB_CHARGECODE_ID %>"], [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	</script></div>
<br />
<form name="subCharge" method="post" action=""><input
	type="hidden" name="title" value="DiagParam"> <input
	type="hidden" name="<%=JSP_NAME %>" value="diagParam"> <br />

<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font> Seq.No.</label> <input type="text" name="<%=SEQUENCE_NO%>"
	value="" validate="Seq.No.,int,yes" class="textbox_size20"
	MAXLENGTH="9" tabindex=1> <label class="bodytextB_blue"><font
	id="error">*</font> Prefix:</label> <input type="text" name="<%= PREFIX %>"
	value="" validate="Prefix,string,yes" class="textbox_size20"
	MAXLENGTH="4" tabindex=1> <label class="bodytextB_blue"><font
	id="error">*</font>Criteria</label> <select name="<%=CRITERIA %>"
	id="<%=CRITERIA %>" tabindex=1 validate="Criteria,string,yes">
	<option value="">Select</option>
	<option value="c">Continous</option>
	<option value="m">Monthly</option>
	<option value="y">Yearly</option>

</select> <label class="bodytextB_blue"><font id="error">*</font>Main
Charge:</label> <select name="<%= MAIN_CHARGECODE_ID %>"
	validate="Main Charge,string,yes" tabindex=1
	onChange="populateSubChargeCode(this.value,'subCharge')" />
	<option value="">Select</option>
	<% 
				for (MasMainChargecode  masMainChargecode : mainChargeCodeList){
				%>
	<option value="<%=masMainChargecode.getId ()%>"><%=masMainChargecode.getMainChargecodeName()%></option>

	<%}%>
</select> <script type="text/javascript">
          subChargeArray1 = new Array();
			<%
			int count = 0;
			for (Iterator iter = mainChargeCodeList.iterator(); iter.hasNext();) 
			{
				MasMainChargecode mainChargecode = (MasMainChargecode) iter.next();
				for (Iterator iterSubChargecode = subChargeCodeList.iterator(); iterSubChargecode.hasNext();) 
				{
					MasSubChargecode subChargecode = (MasSubChargecode) iterSubChargecode.next();
					if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId())){
								%>
									subChargeArray1[<%=count%>] = new Array();
									subChargeArray1[<%=count%>][0] = <%=mainChargecode.getId()%>;
									subChargeArray1[<%=count%>][1] = <%=subChargecode.getId()%>;									
									subChargeArray1[<%=count%>][2] = "<%=subChargecode.getSubChargecodeName()%>";

								<%
								count++;
						}
					}
				}
			
		%>
		</script> <label class="bodytextB_blue"><font id="error">*</font> Sub
Charge:</label> <select name="<%= SUB_CHARGECODE_ID %>"
	validate="Sub Charge,string,yes" tabindex=1 />
	<option value="">Select</option>
	<% 
				for (MasSubChargecode  massubChargecode : subChargeCodeList){
				%>
	<option value="<%=massubChargecode.getId ()%>"><%=massubChargecode.getSubChargecodeName()%></option>

	<%}%>
</select> <br />
<br />



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
	onClick="submitForm('subCharge','hospital?method=addDiagParam');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('subCharge','hospital?method=editDiagParam')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('subCharge','hospital?method=deleteDiagParam&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= DIAG_ID%>" value="" /> <br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Seq.No."
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEQUENCE_NO%>"

data_header[1] = new Array;
data_header[1][0] = "Prefix"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= PREFIX%>"

data_header[2] = new Array;
data_header[2][0] = "Ctriteria"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "<%= CRITERIA%>"

data_header[3] = new Array;
data_header[3][0] = "Main Charge"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= MAIN_CHARGECODE_ID %>";

data_header[4] = new Array;
data_header[4][0] = "Sub Charge"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%=SUB_CHARGECODE_ID %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_TIME %>"


data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchParamList.iterator();

          int  counter=0;
          while(itr.hasNext())
           {
            
             DiagParam  diagParam = (DiagParam)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= diagParam.getId()%>
data_arr[<%= counter%>][1] = "<%=diagParam.getSeqNo()%>"
data_arr[<%= counter%>][2] = "<%= diagParam.getPrefix()%>"
data_arr[<%= counter%>][3] ="<%=diagParam.getCriteria()%>"

<%
		Iterator itrGridMainChargeList=gridMainChargeList.iterator();
		 while(itrGridMainChargeList.hasNext())
            {
             MasMainChargecode  mainChargeGrid = (MasMainChargecode)itrGridMainChargeList.next(); 
			 if(diagParam.getMainCharge().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=mainChargeGrid.getMainChargecodeName()%>"
			<%}else if(diagParam.getMainCharge().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=mainChargeGrid.getMainChargecodeName()%>";
				
			<%}
}%>
<%
		Iterator itrGridSubChargeList=gridSubChargeList.iterator();
		 while(itrGridSubChargeList.hasNext())
            {
             MasSubChargecode  subChargeGrid = (MasSubChargecode)itrGridSubChargeList.next(); 
			 if(diagParam.getSubCharge().getId().equals(subChargeGrid.getId()) && subChargeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=subChargeGrid.getSubChargecodeName()%>"
			<%}else if(diagParam.getSubCharge().getId().equals(subChargeGrid.getId()) && subChargeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=subChargeGrid.getSubChargecodeName()%>";
				
			<%}
}%>
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(diagParam.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= diagParam.getLastChgTime() %>"

data_arr[<%= counter%>][8] = "<%= diagParam.getLastChgTime() %>"

			
			
<% if(diagParam.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "subCharge"

nonEditable = [['<%= MAIN_CHARGECODE_ID%>'],['<%= SUB_CHARGECODE_ID%>']];

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
