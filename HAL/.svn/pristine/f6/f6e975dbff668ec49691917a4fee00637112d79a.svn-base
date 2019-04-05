<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * transactionSequence.jsp  
 * Purpose of the JSP -  This is for Transaction Sequence.
 * @author  Mansi
 * Create Date: 08th Feb,2013 
 * Revision Date:      
 * Revision By: 
 * @version 1.10  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.TransactionSequence"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchTransactionSequenceList = (ArrayList)map.get("searchTransactionSequenceList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	

%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Transaction Sequence</h2>
</div>
<div class="Clear"></div>


<div id="searcharea">
<div id="searchbar">
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"tSqNo"], [2,"tSqName"],  [3,"tPrefix"], [4,"tableName"],[5,"month"],[6,"serviceTypeId"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
</script></div>

<form name="transactionSequence" method="post" action="">


<div class="Clear"></div>
<div class="Block">


<label> Transaction Sequence No.<span>*</span> </label>
<input type="text"	name="tSqNo" id="tSqNo" value=""	validate="Transaction Sequence No.,int,yes"	MAXLENGTH="8"  tabindex=1/>

<label> Transaction Sequence Name<span>*</span> </label>
<input type="text"	name="tSqName" id="tSqName" value=""	validate="Transaction Sequence Name,string,yes"	MAXLENGTH="30"  tabindex=1/>

<label> Transaction Prefix<span>*</span> </label>
<input type="text"	name="tPrefix" id="tPrefix" value=""	validate="Transaction Prefix,string,yes"	MAXLENGTH="8"  tabindex=1/>


<div class="Clear"></div>

<label>Table Name<span>*</span> </label>
<input type="text"	name="tableName" id="tableName" value=""	validate="Table Name,string,yes"	MAXLENGTH="30" tabindex=1/>

<label>Month<span>*</span> </label>
<input type="text"	name="month" id="month" value=""	validate="Month,int,yes"	MAXLENGTH="8"  tabindex=1/>




</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('transactionSequence','systemRelatedMaster?method=addTransactionSequence');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('transactionSequence','systemRelatedMaster?method=editTransactionSequence')"	accesskey="u" tabindex=1 />
<input type="hidden" name="Delete"	id="deletebutton" value="Activate" class="button"	onClick="submitForm('departmentType','systemRelatedMaster?method=deleteDepartmentType&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" /> 
<input	type="hidden" name="serviceTypeId" value="" />
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>




</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Transaction Sequence No"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "tSqNo"

data_header[1] = new Array;
data_header[1][0] = "Transaction Sequence Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "tSqName";

data_header[2] = new Array;
data_header[2][0] = "Transaction Prefix"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "tPrefix"

data_header[3] = new Array;
data_header[3][0] = "Table Name"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "tableName"

data_header[4] = new Array;
data_header[4][0] = "Month"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "month";

data_header[5] = new Array;
data_header[5][0] = "Service Type Id"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "serviceTypeId";


data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";
data_arr = new Array();

<%
Iterator itr=searchTransactionSequenceList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             TransactionSequence  transactionSequence = (TransactionSequence)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= transactionSequence.getId()%>
data_arr[<%= counter%>][1] = "<%=transactionSequence.getTransactionSequenceNumber()%>"
data_arr[<%= counter%>][2] = "<%= transactionSequence.getTransactionSequenceName()%>"

data_arr[<%= counter%>][3] = "<%= transactionSequence.getTransactionPrefix() %>"
data_arr[<%= counter%>][4] = "<%= transactionSequence.getTablename() %>"
data_arr[<%= counter%>][5] = "<%= transactionSequence.getMonth() %>"
	<% if(transactionSequence.getServiceType()!=null){ %>

	data_arr[<%= counter%>][6] = "<%= transactionSequence.getServiceType().getId() %>"
		<%}else{%>
		data_arr[<%= counter%>][6] =""
		<%}
 if(transactionSequence.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "transactionSequence"

//nonEditable = ['tSqNo'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
