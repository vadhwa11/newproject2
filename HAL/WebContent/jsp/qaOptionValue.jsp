<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * qaOptionValue.jsp  
 * Purpose of the JSP - This for admission Type 
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.6  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasQaOptionValue"%>
<%@page import="jkt.hms.masters.business.MasQuestionHeading"%>
<%@page import="jkt.hms.masters.business.OpdQaMaster"%>
<%
		Map map = new HashMap();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		List<MasQaOptionValue> searchQaOptionValueList = (List<MasQaOptionValue>)map.get("searchQaOptionValueList");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		List<MasQuestionHeading> questionHeadingList = new ArrayList<MasQuestionHeading>();
		if(map.get("questionHeadingList") != null){
			questionHeadingList = (List<MasQuestionHeading>)map.get("questionHeadingList");
		}
		
		List<OpdQaMaster> questionnaireList = new ArrayList<OpdQaMaster>();
		if(map.get("questionnaireList") != null){
			questionnaireList = (List<OpdQaMaster>)map.get("questionnaireList");
		}
		

%>

<script>
function validateOptionSno()
{
	var val=document.getElementById('optionSNo').value;
if(val=="")
	{
		alert("Please fill Option S No.")
		return false;
	}
return true;
}
</script>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Option Value Master</h2>
</div>
	  <div id="searcharea">
	  
			  <form name="search" method="post" action="">
			  
			  
		 
		 <%--  <div class="Block">	    
			    	<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
					<label>Option Value Code</label>
					<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />
					<label>Option Value Name</label>
					 <input type="text" id="searchField"   name="<%= SEARCH_FIELD%>" value=""  validate="Option Value Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'opdMaster?method=searchQaOptionValue')"/>
					 
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','opdMaster?method=searchQaOptionValue','checkSearch')" tabindex=1  />
                    - Report Button   
                    <!--  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/> -->
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_qa_option_value">

		     <div class="Clear"></div>
		     </div> --%>
		     
		       <div class="Block">

	  	<label> Question Heading </label>
		<select name="questionId" id="questionId"  onchange="fnGetQuestionnaire(this.value,'questionnaireDivSearch','y');" validate="Question Heading,string,no"		tabindex=1>
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
  		<div id = "questionnaireDivSearch">
		<select name ="questionnaireId"  class="large" id ="questionnaireId"  validate="Question,string,yes" tabindex=1>
				<option value="0">Select</option>
                <%
			           		if(questionnaireList != null){ 	
			           			for (Iterator iter = questionnaireList.iterator(); iter.hasNext();) {
			           				OpdQaMaster questionnaire = (OpdQaMaster) iter.next();
			           %>
				<option value="<%=questionnaire.getId() %>"><%=questionnaire.getQuestion() %></option>
				<%		
			          			}
			          		 } 
			          %>
				
			</select>
			
		</div>
			<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','opdMaster?method=searchQaOptionValue')" tabindex=1  />
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
		if(searchQaOptionValueList.size()>0)
		 {
			String strForCode = (String)map.get("qaOptionValueCode");
			String strForCodeDescription = (String)map.get("qaOptionValueName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
  
    <h4><a href="opdMaster?method=showQaOptionValueJsp">Show All Records</a></h4>
	<%
			}
		 }
	 if(searchQaOptionValueList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="opdMaster?method=showQaOptionValueJsp">Show All Records</a></h4>

	 <%
     }
	%>

	<script type="text/javascript">
	
	formFields = [
		[0, "<%= COMMON_ID%>", "id"],[1,"heading"], [2,"questionnaireId"], [3,"<%= SEARCH_NAME %>"], [4,"<%= CODE%>"], [5,"optionSNo"], [6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script>
	</div>
	
  <form name="qaOptionValue" method="post" action="">
 		
	  		
	  		
 	<div class="Clear"></div>
 	
 		  <div class="Block">

	  	<label> Question Heading </label>
		<select name="questionId" id="questionId"  onchange="fnGetQuestionnaire(this.value,'questionnaireDiv','y');" validate="Question Heading,string,no"		tabindex=1>
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
  		<div id = "questionnaireDiv">
		<select name ="questionnaireId"  class="large" id ="questionnaireId"  validate="Question,string,yes" tabindex=1>
				<option value="0">Select</option>
                <%
			           		if(questionnaireList != null){ 	
			           			for (Iterator iter = questionnaireList.iterator(); iter.hasNext();) {
			           				OpdQaMaster questionnaire = (OpdQaMaster) iter.next();
			           %>
				<option value="<%=questionnaire.getId() %>"><%=questionnaire.getQuestion() %></option>
				<%		
			          			}
			          		 } 
			          %>
				
			</select>
			
		</div>
			
			   <div class="Clear"></div>
		
				
			
			
			</div>
		 
		 
<div class="Block">	

	  	<label > Option Value Code<span>*</span> </label>
		<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Option Value Code,string,no"  MAXLENGTH="8" tabindex=1 >
		
			<label > Score <span>*</span></label>
			<input type="text" name="optionSNo" id="optionSNo" value="" validate="Score,int,no"  MAXLENGTH="4" tabindex=1  >
		
		<div class="Clear"></div>
  			<label > Option Value Name <span>*</span></label>
			<input type="text" style="width: 500px;" name="<%= SEARCH_NAME %>" value="" validate="Option Value Name,string,yes"  MAXLENGTH="998" tabindex=1 onkeypress="return submitenter(this,event,'opdMaster?method=addQaOptionValue')">
			<script>
				document.qaOptionValue.<%=CODE%>.focus();
			</script>
			</div>
<div class="Clear"></div>

          
   <div id="edited"></div>
   <div class="Clear"></div>
   <div class="division"></div>
   <div class="Clear"></div>
   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="if(validateOptionSno()){submitForm('qaOptionValue','opdMaster?method=addQaOptionValue');}" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('qaOptionValue','opdMaster?method=editQaOptionValue')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('qaOptionValue','opdMaster?method=deleteQaOptionValue&flag='+this.value)" accesskey="d" tabindex=1/>		

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

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Heading"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "heading"

	data_header[1] = new Array;
data_header[1][0] = "Question"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "questionnaireId"


	data_header[2] = new Array;
data_header[2][0] = "Option Value Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= SEARCH_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Option Value Code"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "<%= CODE%>"


	data_header[4] = new Array;
data_header[4][0] = "Score"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "optionSNo";


data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_TIME %>"


data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
int  counter=0;
             for(MasQaOptionValue  masQaOptionValue :searchQaOptionValueList) 
             {

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masQaOptionValue.getId()%>"
data_arr[<%= counter%>][1] = "<%=masQaOptionValue.getQuestion().getQuestionHeading().getQuestionHeadingName()%>"
	data_arr[<%= counter%>][2] = "<%= masQaOptionValue.getQuestion().getQuestion()%>"
		data_arr[<%= counter%>][3] = "<%= masQaOptionValue.getQaOptionValueName()%>"
data_arr[<%= counter%>][4] = "<%=masQaOptionValue.getQaOptionValueCode()%>"
	data_arr[<%= counter%>][5] = "<%= masQaOptionValue.getOptionSNo() %>"



data_arr[<%= counter%>][6] = "<%= masQaOptionValue.getLastChgTime() %>"

<% if(masQaOptionValue.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "qaOptionValue"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  