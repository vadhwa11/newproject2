	<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * tradeValidate.jsp  
	 * Purpose of the JSP -  This is for Country Details.
	 * @author  
	 * @author  
	 * Create Date: 10th september,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version   
	--%>
	
	<%@ page import="static jkt.hms.util.RequestConstants.*" %>
	<%@ page import="java.util.*" %>
	<%@ page import="jkt.hms.util.HMSUtil" %>
	<%@page import="jkt.hms.masters.business.MasTrade"%>
	<%@page import="jkt.hms.masters.business.Patient" %>
	<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
	<script type="text/javascript">
	
	
	function openPopupWindowForTrade()
	{
	 var url="/hms/hms/adt?method=showTradeSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	function jsSetTradeData(tradeId)
	{
	 for(var i=0;i<document.getElementById("newTradeId").length;i++)
	 {
		 if (document.getElementById("newTradeId").options[i].value==tradeId)
		 {
		 	document.getElementById("newTradeId").selectedIndex = i;
		 }
		 
		 
	 }
	
	}
	function displayTradeDetails(id){
		document.getElementById("tradeDetails").value ="true"
		submitProtoAjax('tradeValidate','/hms/hms/adt?method=getTradeDetails&id='+id)
	}
	
	function validateTradeValidation(id){
	  var errMsg ="";
	  var status ="";
	if(id > 0){
	
	  if(document.getElementById("tradeDetails").value == "true"){
		    if(document.getElementById("newTradeId").value ==""){
		 	  errMsg = errMsg +"Please select  new Trade name ...!\n";
		    }
		   
		   for(i=1;i<=document.getElementById("chackLength").value;i++){
			   if(document.getElementById("newLocalTrade"+i) != null){
			   	 if(document.getElementById("newLocalTrade"+i).checked){
			    	 status="yes";
			    	}
			    }else if(document.getElementById("newLocalTradeEmpAfmsf"+i) != null ){
			    	if(document.getElementById("newLocalTradeEmpAfmsf"+i).checked ){
			    	 status="yes";
			    	}
			    }
		   }
		    if(status=="yes"){
		    }else{
		 	errMsg = errMsg+"Please select  any service No ...!\n";
		    }
	  }else if(document.getElementById("tradeDetails").value == ""){
	   errMsg = errMsg+"Select one trade";
	  }
	}else{
	  errMsg =  errMsg + "No Records to Validate!!";
	}
	
	 if(errMsg ==""){
		return true
	 }else{
		 alert(errMsg)
		 return false
	  }
	 }
	 
	 function TradeValidation(id){
	  var errMsg ="";
	  	
	  if(id > 0){
	  var status ="";
	   for(var i = 0; i < document.getElementsByName('trade').length; i++){
				  if(document.getElementsByName('trade')[i].checked == true)
	              {
					 status = "Yes";
				  }		
	  		}
	  if(status=="Yes"){
	    }else{
		 	errMsg = errMsg+"Please select  atleast one Trade ...!";
		    }
	  }else{
	   errMsg =  errMsg + "No Records to Validate!!";
	  }
	 
	 
	 if(errMsg ==""){
		return true
	 }else{
	 alert(errMsg)
	 return false
	  }
	 }
	</script>
	
	<%
		Map map = new HashMap();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		ArrayList searchTradeList = (ArrayList)map.get("searchTradeList");
		
		if(map.get("patientDetailsList") != null)	{
			Patient patientdetails = (Patient)map.get("patientDetailsList");
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
	   <% 
	  }

%>
<div class="titleBg">
<h2>Trade Validate</h2>
</div>
<div class="clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<input type="hidden" id="tradeDetails" name="tradeDetails" value=""/>
<input type="hidden" id="count" name="count" value=""/>
<label>Trade Name </label>
<input type="radio" name="<%=SELECTED_RADIO  %>"  class="radio" value="1" checked="checked" />
<!--  <input type="radio" name="<%=SELECTED_RADIO %>" class="radio" value="2"  />-->
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Trade Name,string,no"   MAXLENGTH="30" tabindex=1   onkeypress="return submitenter(this,event,'adt?method=searchTradeValidate')"/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','adt?method=searchTradeValidate','checkSearch')" tabindex=1  />
</div>
</form>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="tradeValidate" method="post" action="">				 
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>
	
		<%
		if(searchTradeList!= null && searchTradeList.size()==0 && map.get("search") != null)
		  {
		 %>
<h4><a href="adt?method=showTradeValidateJsp">Show All Records</a></h4>
		 <%
	     }
		%>
		
<script type="text/javascript">
		formFields = [
			   [0, "<%= TRADE_ID%>"],[1,"<%= RADIO_FOR_TABLE%>"],[2,"<%= TRADE_NAME%>"],[3,"<%= UNIT_ADDRESS %>"],[4,"<%=LOCAL_TRADE%>"],[5,"<%= STATUS%>"], [6,"<%= CHANGED_BY %>"],[7,"<%= CHANGED_DATE %>"],[8,"<%=CHANGED_TIME%>"]];
		 statusTd = 8;
</script>
</div>
		
<div class="clear"></div>
	 
<div id="testDiv">
	      
	      <% if(map.get("tradeList") != null){
	          MasTrade  tempMasTrade = (MasTrade)map.get("tradeList");
	      %>
<div class="Block">
<label>Trade Name </label> 
<label class="value"><%=tempMasTrade.getTradeName()%></label>
<input type="text" name = "tradeName" value="<%=tempMasTrade.getTradeName() %>" id="tradeName">
</div>
		 <% }%>	
</div>	
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	   <%if(searchTradeList!=null){ %>
<input type="button" name="add" id="addbutton" value="Validate Trade" class="buttonBig" onClick="if(TradeValidation(<%=searchTradeList.size()%>)){submitForm('tradeValidate','adt?method=validateTrade');}" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="addbutton" value="Update Trade" class="buttonBig" onClick="if(validateTradeValidation(<%=searchTradeList.size()%>)){submitForm('tradeValidate','adt?method=updateValidateTrade');}" accesskey="u" tabindex=1 />
		
		<%}else{ %>
		
		 <!-- 		<input type="button" name="add" id="addbutton" value="Validate Trade" class="buttonbig" onClick="submitForm('tradeValidate','adt?method=validateTrade');" accesskey="a" tabindex=1/>
		<input type="button" name="edit" id="addbutton" value="Update Trade" class="buttonbig" onClick="submitForm('tradeValidate','adt?method=updateValidateTrade');" accesskey="u" tabindex=1 />
		 -->
		<%} %>
<input type="button" name="delete" id="deleteTradeId" value="Delete Trade" class="buttonBig" onClick="submitForm('tradeValidate','adt?method=deleteValidateTrade');" accesskey="u" tabindex=1 style="display: none;" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

    <!-- submitForm('tradeValidate','adt?method=validateTrade');
		    <input type="button" name="edit" id="addbutton" value="Update Trade" class="button" onClick="submitForm('tradeValidate','adt?method=updateValidateTrade');" accesskey="u" tabindex=1 />
		-->
</form>
	
<script type="text/javascript">
	
	data_header = new Array();
	
	 data_header[0] = new Array;
	data_header[0][0] = ""
	data_header[0][1] = "radio";
	data_header[0][2] = "4%";
	data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
	
	 data_header[1] = new Array;
	data_header[1][0] = "TRADE NAME"
	data_header[1][1] = "data";
	data_header[1][2] = "30%";
	data_header[1][3] = "<%= TRADE_NAME %>";
	
	 data_header[2] = new Array;
	data_header[2][0] = "Trade Address"
	data_header[2][1] = "hide";
	data_header[2][2] = "10%";
	data_header[2][3] = "<%=UNIT_ADDRESS %>";
	
	 data_header[3] = new Array;
	data_header[3][0] = "Is Local Trade"
	data_header[3][1] = "hide";
	data_header[3][2] = "15%";
	data_header[3][3] = "<%= LOCAL_TRADE %>";
	
	 data_header[4] = new Array;
	data_header[4][0] = ""
	data_header[4][1] = "hide";
	data_header[4][2] = 0;
	data_header[4][3] = "<%= STATUS %>"
	
	data_header[5] = new Array;
	data_header[5][0] = ""
	data_header[5][1] = "hide";
	data_header[5][2] = 0;
	data_header[5][3] = "<%= CHANGED_BY %>"
	
	data_header[6] = new Array;
	data_header[6][0] = ""
	data_header[6][1] = "hide";
	data_header[6][2] = 0;
	data_header[6][3] = "<%= CHANGED_DATE %>"
	
	data_header[7] = new Array;
	data_header[7][0] = ""
	data_header[7][1] = "hide";
	data_header[7][2] = 0;
	data_header[7][3] = "<%=CHANGED_TIME %>";
	
	
	data_arr = new Array();
	
	<%
	if(searchTradeList!= null){
	Iterator itr=searchTradeList.iterator();
	
	          int  counter=0;
	         
	          while(itr.hasNext())
	           {
	            
	             MasTrade  masTrade = (MasTrade)itr.next(); 
	          //   if(masTrade.getPatients().size() !=0 || masTrade.getEmpAfmsfDets().size() != 0){
	%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= masTrade.getId()%>
	data_arr[<%= counter%>][1] = '<input type="radio" id="trade" name="trade" value="<%= masTrade.getId()%>"  onclick="displayTradeDetails(<%= masTrade.getId()%>)" />'
	<%
	if(masTrade.getTradeName() !="" || masTrade.getTradeName() != null){
	%>
		data_arr[<%= counter%>][2] = "<%=masTrade.getTradeName()%>"
	<%	
	}else{
	%>
	   data_arr[<%= counter%>][2] = "<%=""%>"
	<%
	}%>
data_arr[<%= counter%>][3] = ''
	   data_arr[<%= counter%>][4] = ''
	
	   data_arr[<%= counter%>][5] = "<%= masTrade.getStatus()%>"
	   data_arr[<%= counter%>][6] = "<%= masTrade.getLastChgBy()%>"
	   <%if(masTrade.getLastChgDate() !=null){%>
	   data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masTrade.getLastChgDate())%>"
	   <%}%>
	   data_arr[<%= counter%>][8] = "<%= masTrade.getLastChgTime()%>"
	<%
	     counter++;
	 
	}}
	%>
	
	formName = "tradeValidate"
	
	 nonEditable = ['<%= TRADE_NAME%>']; 
	   
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>	
	
	<script>
	document.getElementById("tradeDetails").value =""
	</script>
	
