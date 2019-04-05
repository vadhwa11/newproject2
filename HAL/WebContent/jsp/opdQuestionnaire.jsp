
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * title.jsp  
 * Purpose of the JSP -  This is for Title.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%>
<%@page import="jkt.hms.masters.business.MasQaOptionValue"%>
<%@page import="jkt.hms.masters.business.MasQuestionHeading"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.masters.business.OpdQaMaster"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchOpdQuestionnaireList = (ArrayList)map.get("searchOpdQuestionnaireList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	List<MasQuestionHeading> questionHeadingList = new ArrayList<MasQuestionHeading>();
	if(map.get("questionHeadingList") != null){
		questionHeadingList = (List<MasQuestionHeading>)map.get("questionHeadingList");
	}
	
	List<MasQaOptionValue> masQaOptionValueList = new ArrayList<MasQaOptionValue>();
	if(map.get("masQaOptionValueList") != null){
		masQaOptionValueList = (List<MasQaOptionValue>)map.get("masQaOptionValueList");
	}
	
	
	String search="";
	if(map.get("search") != null){
		    search = (String)map.get("search");}
	
%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Opd Questionnaire Master</h2>
</div>
	  <div id="searcharea">
	  
		
		  
			  <form name="search" method="post" action="">
			    <div class="Block">
			    <label>Question Heading</label>
			    	<select name="questionIdSearch" id="questionIdSearch" 	 validate="Question Heading ,string,no" 		tabindex=1>
					<option value="0">Select</option>

				<%
			           		if(questionHeadingList != null){ 	
			           			for (Iterator iter = questionHeadingList.iterator(); iter.hasNext();) {
			           				MasQuestionHeading masQuestionHeading = (MasQuestionHeading) iter.next();
			           %>
				<option value="<%=masQuestionHeading.getId() %>"><%=masQuestionHeading.getQuestionHeadingName() %></option>
				<%		
			          			}
			          		 } 
			          %>
			</select>
			    	
			    	<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','/hms/hms/opdMaster?method=searchOpdQuestionnaire')" tabindex=1  />
		    		         
		 	            <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report" class="buttonBig3" onClick="submitForm('search','opdMaster?method=generateReportForOpdQuestionnaire');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="questionHeading">
		     <div class="Clear"></div>
		 </div>
</form>


		
 </div>

			 	 
	<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(search.equalsIgnoreCase("search"))
		 {%>
			
				
    <h4><a href="opdMaster?method=showOpdQuestionnaireJsp">Show All Records</a></h4>

	<%
	 }
		%>
	
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"questionId"], [2,"question"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"optionValue"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script>
	</div>
	
  <form name="title" method="post" action="">
  		
<div class="Clear"></div>
<div class="Block">

	  	<label> Question Heading<span>*</span> </label>
		<select name="questionId" id="questionId" 	 validate="Question Heading,string,no"		tabindex=1>
				<option value="0">Select</option>

				<%
			           		if(questionHeadingList != null){ 	
			           			for (Iterator iter = questionHeadingList.iterator(); iter.hasNext();) {
			           				MasQuestionHeading masQuestionHeading = (MasQuestionHeading) iter.next();
			           %>
				<option value="<%=masQuestionHeading.getId() %>"><%=masQuestionHeading.getQuestionHeadingName() %></option>
				<%		
			          			}
			          		 } 
			          %>
			</select>
			
			
		
		
		
  		<label >Question <span>*</span> </label>
  		<textarea class="large" rows="" cols="" onkeyup="auto_grow(this)" onpaste="return checkOnPaste(this)" name ="question"   id ="question" oninput="return checkMaxLengthMoz(this)" maxlength="450"	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"></textarea>
		
			<script>
				document.title.questionId.focus();
			</script>
			
			   <div class="Clear"></div>
			<%-- 	<label> Option Value <span>*</span> </label>
				<select name="optionValue" id="optionValue" validate="Option Value,string,no" >
				<option value="">Select</option>
				<%
			           		if(masQaOptionValueList != null){ 	
			           			for (Iterator iter = masQaOptionValueList.iterator(); iter.hasNext();) {
			           				MasQaOptionValue masQaOptionValue = (MasQaOptionValue) iter.next();
			           %>
				<option value="<%=masQaOptionValue.getOptionSNo() %>"><%=masQaOptionValue.getOptionSNo() %></option>
				<%		
			          			}
			          		 } 
			          %>
			</select> --%>
				
			
			
			</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="if(validateOptionValue()){submitForm('title','opdMaster?method=addOpdQuestionnaire');}" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('title','opdMaster?method=updateOpdQuestionnaire')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('title','opdMaster?method=deleteOpdQuestionnaire&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			
		
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
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
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   </div>	
	<div class="Clear"></div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Question Heading"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "questionId"

data_header[1] = new Array;
data_header[1][0] = "Question"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "question";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Option Value"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "optionValue";




data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchOpdQuestionnaireList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             OpdQaMaster  opdQaMaster = (OpdQaMaster)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= opdQaMaster.getId()%>

<% if(opdQaMaster.getQuestionHeading() != null){

	Iterator itrQuestionHeadingList=questionHeadingList.iterator();
	 while(itrQuestionHeadingList.hasNext())
        {
		 MasQuestionHeading  masQuestionHeadingGrid = (MasQuestionHeading)itrQuestionHeadingList.next(); 
		 if(opdQaMaster.getQuestionHeading().getId().equals(masQuestionHeadingGrid.getId()) && masQuestionHeadingGrid.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][1] = "<%=masQuestionHeadingGrid.getQuestionHeadingName()%>"
		<%}else if(opdQaMaster.getQuestionHeading().getId().equals(masQuestionHeadingGrid.getId()) && masQuestionHeadingGrid.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masQuestionHeadingGrid.getQuestionHeadingName()%>";
				
		<%}
        }
}else{%>
data_arr[<%= counter%>][1]=""
<%}%>
data_arr[<%= counter%>][2] = "<%=opdQaMaster.getQuestion()%>"

	data_arr[<%= counter%>][3] = "<%= opdQaMaster.getLastChgBy()!=null?(opdQaMaster.getLastChgBy().getId()!=null?opdQaMaster.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(opdQaMaster.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= opdQaMaster.getLastChgTime() %>"
	data_arr[<%= counter%>][6] = "<%=opdQaMaster.getOptionValue()!=null?opdQaMaster.getOptionValue():"0"%>"
<% if(opdQaMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "title"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  
	  
	  <script>
	  
	  function validateOptionValue()
	  {
		/* var val=document.getElementById('optionValue').value; */
		var question=document.getElementById('question').value;
		var questionId=document.getElementById('questionId').value;
		
		/*   if(val==''){
			  alert("Select Option value");
				return false;
		  } */
		  if(question==''){
			  alert("Select Question");
				return false;
		  }

		  if(questionId=='0'){
			  alert("Select Question Heading");
				return false;
		  }

		  return true;
	  }
	  </script>