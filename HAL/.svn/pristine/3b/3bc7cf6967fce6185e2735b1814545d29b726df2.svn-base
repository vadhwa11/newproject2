
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * unitValidate.jsp  
	 * Purpose of the JSP -  This is for Country Details.
	 * @author  
	 * @author  
	 * Create Date: 10th september,2008 
	 * Revision Date:      
	 * Revision By: 
	 * @version   
	--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
	
	
	function openPopupWindowForUnit()
	{
	 var url="/hms/hms/adt?method=showUnitSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	function jsSetUnitData(unitId,unitAddress)
	{
	 for(var i=0;i<document.getElementById("newUnitId").length;i++)
	 {
		 if (document.getElementById("newUnitId").options[i].value==unitId)
		 {
		 	document.getElementById("newUnitId").selectedIndex = i;
		 }
		 
		 if(unitAddress != "" && unitAddress != null){
	       document.getElementById('sUnitAddress').value =unitAddress
	     }
	 }
	
	}
	function displayUnitDetails(id){
		document.getElementById("unitDetails").value ="true"
		submitProtoAjax('unitValidate','/hms/hms/adt?method=getUnitDetails&id='+id)
	}
	
	function validateUnitValidation(id){
	  var errMsg ="";
	  var status ="";
	if(id > 0){
	
	  if(document.getElementById("unitDetails").value == "true"){
		    if(document.getElementById("newUnitId").value ==""){
		 	  errMsg = errMsg +"Please select  new Unit name ...!\n";
		    }
		   
		   for(i=1;i<=document.getElementById("chackLength").value;i++){
			   if(document.getElementById("newLocalUnit"+i) != null){
			   	 if(document.getElementById("newLocalUnit"+i).checked){
			    	 status="yes";
			    	}
			    }else if(document.getElementById("newLocalUnitEmpAfmsf"+i) != null ){
			    	if(document.getElementById("newLocalUnitEmpAfmsf"+i).checked ){
			    	 status="yes";
			    	}
			    }
		   }
		    if(status=="yes"){
		    }else{
		 	errMsg = errMsg+"Please select  any service No ...!\n";
		    }
	  }else if(document.getElementById("unitDetails").value == ""){
	   errMsg = errMsg+"Select one unit";
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
	 
	 function UnitValidation(id){
	  var errMsg ="";
	  	
	  if(id > 0){
	  var status ="";
	   for(var i = 0; i < document.getElementsByName('unit').length; i++){
				  if(document.getElementsByName('unit')[i].checked == true)
	              {
					 status = "Yes";
				  }		
	  		}
	  if(status=="Yes"){
	    }else{
		 	errMsg = errMsg+"Please select  atleast one Unit ...!";
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
		ArrayList searchUnitList = (ArrayList)map.get("searchUnitList");
		
		if(map.get("patientDetailsList") != null)	{
			Patient patientdetails = (Patient)map.get("patientDetailsList");
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
	%> <%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %> <h4><span><%=message %></span></h4> <% 
	  }

%>

<div class="titleBg">
<h2>Unit Validate</h2>
</div>
<div class="clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<input type="hidden" id="unitDetails" name="unitDetails" value="" /> 
<input type="hidden" id="count" name="count" value="" /> 
<label>Unit Name </label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" class="radioAuto" value="1" checked="checked" /> 
<label>Unit Address </label> 
<input type="radio" name="<%=SELECTED_RADIO %>" class="radioAuto" value="2" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Unit Name,string,no" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'adt?method=searchUnitValidate')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','adt?method=searchUnitValidate','checkSearch')" tabindex=1 />
</div>
</form>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="unitValidate" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<%
		if(searchUnitList.size()==0 && map.get("search") != null)
		  {
		 %>
<h4><a href="adt?method=showUnitValidateJsp">Show All Records</a></h4>
<%
	     }
		%> <script type="text/javascript">
		formFields = [
			   [0, "<%= UNIT_ID%>"],[1,"<%= RADIO_FOR_TABLE%>"],[2,"<%= UNIT_NAME%>"],[3,"<%= UNIT_ADDRESS %>"],[4,"<%=LOCAL_UNIT%>"],[5,"<%= STATUS%>"], [6,"<%= CHANGED_BY %>"],[7,"<%= CHANGED_DATE %>"],[8,"<%=CHANGED_TIME%>"]];
		 statusTd = 8;
		</script>
</div>

<div class="clear"></div>

<div id="testDiv">
<% if(map.get("unitList") != null){
	          MasUnit  tempMasUnit = (MasUnit)map.get("unitList");
	      %>
<div class="Block">
<label>Unit Name </label> 
<label class="value"><%=tempMasUnit.getUnitName()%></label>
</div>
<% }%>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Validate Unit" class="buttonBig" onClick="if(UnitValidation(<%=searchUnitList.size()%>)){submitForm('unitValidate','adt?method=validateUnit');}" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="addbutton" value="Update Unit" class="buttonBig" onClick="if(validateUnitValidation(<%=searchUnitList.size()%>)){submitForm('unitValidate','adt?method=updateValidateUnit');}" accesskey="u" tabindex=1 /> 
<input type="button" name="delete" id="deleteUnitId" value="Delete Unit" class="button" onClick="submitForm('unitValidate','adt?method=deleteValidateUnit');" accesskey="u" tabindex=1 style="display: none;" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!-- submitForm('unitValidate','adt?method=validateUnit');
		    <input type="button" name="edit" id="addbutton" value="Update Unit" class="button" onClick="submitForm('unitValidate','adt?method=updateValidateUnit');" accesskey="u" tabindex=1 />
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
	data_header[1][0] = "UNIT NAME"
	data_header[1][1] = "data";
	data_header[1][2] = "30%";
	data_header[1][3] = "<%= UNIT_NAME %>";
	
	 data_header[2] = new Array;
	data_header[2][0] = "Unit Address"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "<%=UNIT_ADDRESS %>";
	
	 data_header[3] = new Array;
	data_header[3][0] = "Is Local Unit"
	data_header[3][1] = "data";
	data_header[3][2] = "15%";
	data_header[3][3] = "<%= LOCAL_UNIT %>";
	
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
	Iterator itr=searchUnitList.iterator();
	          int  counter=0;
	         
	          while(itr.hasNext())
	           {
	            
	             MasUnit  masUnit = (MasUnit)itr.next(); 
	          //   if(masUnit.getPatients().size() !=0 || masUnit.getEmpAfmsfDets().size() != 0){
	%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= masUnit.getId()%>
	data_arr[<%= counter%>][1] = '<input type="radio" id="unit" name="unit" value="<%= masUnit.getId()%>"  onclick="displayUnitDetails(<%= masUnit.getId()%>)" />'
	<%
	if(masUnit.getUnitName() !="" || masUnit.getUnitName() != null){
	%>
		data_arr[<%= counter%>][2] = "<%=masUnit.getUnitName()%>"
	<%	
	}else{
	%>
	   data_arr[<%= counter%>][2] = "<%=""%>"
	<%
	}
	if(masUnit.getUnitAddress() !="" || masUnit.getUnitAddress() != null){
	%>
		data_arr[<%= counter%>][3] = "<%=masUnit.getUnitAddress()%>"
	<%	
	}else{
	%>
	   data_arr[<%= counter%>][3] = "<%=""%>"
	<%
	}
	if(masUnit.getLocalUnit().equals("n")){ 
	%>
	   data_arr[<%= counter%>][4] = '<input type="checkbox" id="localUnit" name="localUnit" />'
	<%}else{%>
	   data_arr[<%= counter%>][4] = '<input type="checkbox" id="localUnit" name="localUnit" checked="true" />'
	<%}%>
	   data_arr[<%= counter%>][5] = "<%= masUnit.getStatus()%>"
	   data_arr[<%= counter%>][6] = "<%= masUnit.getLastChgBy()%>"
	   <%if(masUnit.getLastChgDate() !=null){%>
	   data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masUnit.getLastChgDate())%>"
	   <%}%>
	   data_arr[<%= counter%>][8] = "<%= masUnit.getLastChgTime()%>"
	<%
	     counter++;
	 
	}//}
	%>
	
	formName = "unitValidate"
	
	 nonEditable = ['<%= UNIT_NAME%>']; 
	   
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>

<script>
	document.getElementById("unitDetails").value =""
	</script>

