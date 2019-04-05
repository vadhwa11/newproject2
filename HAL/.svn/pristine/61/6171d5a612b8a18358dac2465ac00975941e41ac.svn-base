<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dietExtraItemFormula.jsp  
 * Purpose of the JSP -  This is for Diet Extra Item Formula.
 * @author Ritu
 * Create Date: 8th Sep,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.8
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasStoreUnit"%>
<%@page import="jkt.hms.masters.business.DietExtraItemFormula"%>
<%@page import="jkt.hms.masters.business.MasDietIndentItem"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<div id="contentHolder">

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<DietExtraItemFormula> extraItemFormulaList = new ArrayList<DietExtraItemFormula>();
	List<MasDietIndentItem> indentItemList = new ArrayList<MasDietIndentItem>();
	List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();
	
	if(map.get("extraItemFormulaList") != null){
		extraItemFormulaList = (List<DietExtraItemFormula>)map.get("extraItemFormulaList");
	}
	if(map.get("uomList") != null){
		uomList = (List<MasStoreUnit>)map.get("uomList");
	}
	if(map.get("indentItemList") != null){
		indentItemList = (List<MasDietIndentItem>)map.get("indentItemList");
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
		   
		   <label class="noWidth"><span><%=message%></span></label>
		    <%
		  }
	 %>


<h6>Diet Extra Item Formula</h6>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
		  <div class="header">
			  <form name="search" method="post" action="">
			    <label>Item Name:</label>
				<input type="text" id="searchField" name="<%=ITEM_NAME%>" value=""  validate="Item Name,string,no" MAXLENGTH="8" onkeypress="return submitenter(this,event,'diet?method=searchExtraItemFormula')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','diet?method=searchExtraItemFormula','checkSearch')" tabindex=1  />
		    <%--- Report Button   --%> <%----  <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/> ----%>
     <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_diet_combination">
		     </form>
		    <div class="Clear"></div>
		    </div>
		 </div>
 </div>
<div class="Clear"></div>
	<jsp:include page="searchResultBlock.jsp" />
	<div class="Clear"></div>
	<div id="searchresults" >
	<div id="searchtable" ></div>
	
	<% try{
		if(extraItemFormulaList.size()>0 )
		 {
			String itemName = (String)map.get("itemName");
			if(itemName!= null && itemName!= "")
			{
	%> 
		
<h2>
    <a href="diet?method=showExtraItemFormulaJsp">Show All Records</a></h2>
	<%
			}
		 }
		 if(extraItemFormulaList.size()==0 && map.get("search") != null)
		  {
	%>	 			
	 			  <h2>
	 			  	<a href="diet?method=showExtraItemFormulaJsp">Show All Records</a></h2>
	<%
      }}
	      catch(Exception ex){
	    	  ex.printStackTrace();
	      }
%>
	<script type="text/javascript">
	
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= ITEM_ID%>"], [2,"<%= EXTRA_SCALE %>"], [3,"<%= UNIT_ID%>"],[4,"<%= VALID_FROM_DATE %>"], [5,"<%= CHANGED_BY %>"],[6,"<%= CHANGED_DATE%>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script>
	</div>
	<div class="Clear"></div>
	
  <form name="extraItemFormula" method="post" action="">
 	<div class="blockFrame">
 	
 		<label><span>*</span> Item Name:</label>
		<select id="menuItemId" name="<%= ITEM_ID %>" validate="Item Name,string,yes" tabindex=1 >
			<option value="">Select</option>
			<% 
				for (MasDietIndentItem indentItem : indentItemList){
				%>
		    
			  <option value="<%=indentItem.getId ()%>"><%=indentItem.getIndentItemName()%></option>
			  		  
			  <%}%>
		</select>
		
			
	  	<label ><span>*</span> Extra Scale</label>
		<input type="text" name="<%= EXTRA_SCALE%>" value="" validate="Extra Scale,num,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 />
				
		<label ><span>*</span> UOM:</label>
		<select name="<%= UNIT_ID %>" validate="UOM,string,yes" tabindex=1 >
		<option value="">Select</option>
		  <% 
			for (MasStoreUnit  storeUnit : uomList){
			%>
		  <option value="<%=storeUnit.getId ()%>"><%=storeUnit.getUnitName()%></option>
		  		  
		  <%}%>
		</select>
			
		<div class="Clear"></div>
		
		<label> <span>*</span> Validity Start Date:</label>
		<input type="text" id="validFromDateId" name="<%=VALID_FROM_DATE %>" value="" class="calDate" readonly="readonly" validate="Validity Start Date ,date,yes"  MAXLENGTH="30" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('',document.extraItemFormula.<%=VALID_FROM_DATE%>,event)"/> 
</div>
		<div class="Clear"></div>
		<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('extraItemFormula','diet?method=addExtraItemFormula','checkValidityStartDate');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('extraItemFormula','diet?method=editExtraItemFormula')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('extraItemFormula','diet?method=deleteExtraItemFormula&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
		<div class="Clear"></div>
		<div class="bottom">
		<label >Changed By:</label>   
		<label class="value"><%=userName%></label>
		        
		<label >Changed Date:</label>   
		<label class="value"><%=currentDate%></label>
		 
		<label>Changed Time:</label>   
		<label class="value"><%=time%></label>
		 
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>"  />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
   </div>	
				
			
	
	</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Item Name"
data_header[0][1] = "data";
data_header[0][2] = "30%";
data_header[0][3] = "<%= ITEM_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Extra Scale"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%=EXTRA_SCALE %>";

data_header[2] = new Array;
data_header[2][0] = "UOM"
data_header[2][1] = "data";
data_header[2][2] = "30%";
data_header[2][3] = "<%=UNIT_ID %>"

data_header[3] = new Array;
data_header[3][0] = "Validity Start Date"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=VALID_FROM_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%=CHANGED_BY %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%=CHANGED_DATE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "0";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "40%";
data_header[7][3] = "<%=STATUS %>"

data_arr = new Array();

<%

          int  counter=0;
         for(DietExtraItemFormula extraItemFormula : extraItemFormulaList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= extraItemFormula.getId()%>

<% 
	if(extraItemFormula.getIndentItem() != null){
%>
<%
		for(MasDietIndentItem obj : indentItemList){
			 if(extraItemFormula.getIndentItem().getId().equals(obj.getId()) && obj.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][1] = "<%=obj.getIndentItemName()%>"
			<%}else if(extraItemFormula.getId().equals(obj.getId()) && obj.getStatus().equals("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=obj.getIndentItemName()%>";
			<%}
            }
		}
%>
data_arr[<%= counter%>][2] = "<%= extraItemFormula.getExtraScale()%>"
<% 
	if(extraItemFormula.getUnit() != null){
%>
<%
		for(MasStoreUnit storeUnit : uomList){
            
			 if(extraItemFormula.getUnit().getId().equals(storeUnit.getId()) && storeUnit.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=storeUnit.getUnitName()%>"
			<%}else if(extraItemFormula.getId().equals(storeUnit.getId()) && storeUnit.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=storeUnit.getUnitName()%>";
			<%}
         }
		}
%>

data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(extraItemFormula.getValidityStartDate()) %>"
data_arr[<%= counter%>][5] = "<%= extraItemFormula.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(extraItemFormula.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= extraItemFormula.getLastChgTime() %>"

<% if(extraItemFormula.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "extraItemFormula"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	

