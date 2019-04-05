<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * dietMenuItemFormula.jsp  
 * Purpose of the JSP -  This is for Diet Menu Item Formula.
 * @author Ritu
 * Create Date: 2nd Sep,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.8
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasDietCombination"%>
<%@page import="jkt.hms.masters.business.DietMenuItemFormula"%>
<%@page import="jkt.hms.masters.business.MasDietItems"%>
<%@page import="jkt.hms.masters.business.MasStoreUnit"%>
<%@page import="jkt.hms.masters.business.MasDietMenuItem"%>
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

<script type="text/javascript">

var itemArray = new Array();
function populateMenuItem(val){
	obj = document.getElementById('menuItemId');
	obj.length = 1;
	for(i=0;i<itemArray.length;i++){
		if(itemArray[i][0]==val){
			obj.length++;
			obj.options[obj.length-1].value=itemArray[i][1];
			obj.options[obj.length-1].text=itemArray[i][2];			
		}
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
	String currentDate = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<DietMenuItemFormula> menuItemFormulaList = new ArrayList<DietMenuItemFormula>();
	List<MasDietItems> dietItemsList = new ArrayList<MasDietItems>();
	List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
	List<MasStoreUnit> uomList = new ArrayList<MasStoreUnit>();
	List<String> menuTypeList = new ArrayList<String>();
	List<MasDietMenuItem> menuItemList = new ArrayList<MasDietMenuItem>();
	
	if(map.get("menuItemFormulaList") != null){
		menuItemFormulaList = (List<DietMenuItemFormula>)map.get("menuItemFormulaList");
	}
	if(map.get("dietItemsList") != null){
		dietItemsList = (List<MasDietItems>)map.get("dietItemsList");
	}
	if(map.get("dietCombinationList") != null){
		dietCombinationList = (List<MasDietCombination>)map.get("dietCombinationList");
	}
	if(map.get("uomList") != null){
		uomList = (List<MasStoreUnit>)map.get("uomList");
	}
	if(map.get("menuTypeList") != null){
		menuTypeList = (List<String>)map.get("menuTypeList");
	}
	if(map.get("menuItemList") != null){
		menuItemList = (List<MasDietMenuItem>)map.get("menuItemList");
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
		   
		   <label class="noWidth"><span><%=message %></span></label>
		   <% 
		  }
%>


<h6>Diet Menu Item Formula</h6>
<div id="searcharea">
<div id="searchbar">
<div class="header">
 <form name="search" method="post" action="">
			    <label>Menu Item:</label>
				<input type="text" id="searchField" name="<%=ITEM_NAME%>" value=""  validate="Item Name,string,no" MAXLENGTH="8" onkeypress="return submitenter(this,event,'diet?method=searchMenuItemFormula')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','diet?method=searchMenuItemFormula','checkSearch')" tabindex=1  />
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
		if(menuItemFormulaList.size()>0 )
		 {
			String itemName = (String)map.get("itemName");
			if(itemName!= null && itemName!= "")
			{
	%> 
		
<h2>
    <a href="diet?method=showMenuItemFormulaJsp">Show All Records</a></h2>
	<%
			}
		 }
		 if(menuItemFormulaList.size()==0 && map.get("search") != null)
		  {
	%>	 			
	 			  <h2>
	 			  	<a href="diet?method=showMenuItemFormulaJsp">Show All Records</a></h2>
	<%
      }}
	      catch(Exception ex){
	    	  ex.printStackTrace();
	      }
%>
	<script type="text/javascript">
	
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= DIET_COMBINATION_ID%>"], [2,"<%= MENU_TYPE %>"], [3,"<%= DIET_ITEMS_ID%>"],[4,"<%= QUANTITY %>"],[5,"<%= UNIT_ID %>"],[6,"<%= PATIENT_CATEGORY %>"],[7,"<%= VALID_FROM_DATE %>"], [8,"<%= CHANGED_BY %>"],[9,"<%= CHANGED_DATE%>"],[10,"<%=CHANGED_TIME%>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script>
	</div>
	<div class="Clear"></div>
  <form name="menuItemFormula" method="post" action="">
   
 	<div class="blockFrame">
 	
 		<label class="noWidth"><span>*</span> Diet Combination:</label>
		<select name="<%= DIET_COMBINATION_ID %>" validate="Diet Combination,string,yes" tabindex=1 >
			<option value="">Select</option>
			  <% 
				
				for (MasDietCombination  masDietCombination : dietCombinationList){
				%>
		    
			  <option value="<%=masDietCombination.getId ()%>"><%=masDietCombination.getDietCombinationName()%></option>
			  		  
			  <%}%>
		</select>
			
 		<label><span>*</span> Menu Type:</label>
		<select name="<%= MENU_TYPE %>" validate="Menu Type,string,yes" tabindex=1 onchange="populateMenuItem(this.value);" >
			<option value="">Select</option>
			<%
			for (Iterator iterator = menuTypeList.iterator(); iterator.hasNext();) {
				String menuType = (String) iterator.next();
				
			%>
			 <option value="<%=menuType %>"><%=menuType %></option>
			
			  <%} %>
		</select>
			
		<label><span>*</span> Menu Item:</label>
		<select id="menuItemId" name="<%= DIET_ITEMS_ID %>" validate="Menu Item,string,yes" tabindex=1 >
			<option value="">Select</option>
			<% 
				for (MasDietItems  masDietItem : dietItemsList){
				%>
		    
			  <option value="<%=masDietItem.getId ()%>"><%=masDietItem.getDietItemsName()%></option>
			  		  
			  <%}%>
		</select>

<div class="Clear"></div>
			
	  	<label><span>*</span> Quantity</label>
		<input type="text" name="<%= QUANTITY%>" value="" validate="Quantity,num,yes" class="textbox_size20" MAXLENGTH="7" tabindex=1 />
			
		<label><span>*</span> UOM:</label>
		<select name="<%= UNIT_ID %>" validate="UOM,string,yes" tabindex=1 >
		<option value="">Select</option>
		  <% 
			for (MasStoreUnit  storeUnit : uomList){
			%>
		  <option value="<%=storeUnit.getId ()%>"><%=storeUnit.getUnitName()%></option>
		  		  
		  <%}%>
		</select>
			
		<label><span>*</span> Patient Category:</label>
		<select name="<%= PATIENT_CATEGORY %>" validate="Patient Category,string,yes" tabindex=1 >
			<option value="">Select</option>
			<option value="General">General</option>
		 	<option value="Officers">Officers</option>
		</select>
			
			<div class="Clear"></div>
			
		<label class="noWidth"><span>*</span> Validity Start Date:</label>
		<input type="text" id="validFromDateId" name="<%=VALID_FROM_DATE %>" value="" class="calDate" readonly="readonly" validate="Validity Start Date ,date,yes"  MAXLENGTH="30" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.menuItemFormula.<%=VALID_FROM_DATE%>,event)"/> 
		
		</div>
		<div class="Clear"></div>
		
		<div id="edited"></div>
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('menuItemFormula','diet?method=addMenuItemFormula','checkValidityStartDate');" accesskey="a" tabindex=1/>
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('menuItemFormula','diet?method=editMenuItemFormula')" accesskey="u" tabindex=1 />
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('menuItemFormula','diet?method=deleteMenuItemFormula&flag='+this.value)" accesskey="d" tabindex=1/>		
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
		
		<div class="Clear"></div>
		<div class="bottom">
		<label>Changed By:</label>   
		<label class="value"><%=userName%></label>
		        
		<label>Changed Date:</label>   
		<label class="value"><%=currentDate%></label>
		 
		<label>Changed Time:</label>   
		<label class="value"><%=time%></label>
		 
		<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
		<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>"  />
		<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
   </div>	
   
   <script type="text/javascript">
		<%
			int count = 0;
			for (Iterator iterator = menuTypeList.iterator(); iterator.hasNext();) {
				String menuType = (String) iterator.next();
				for (MasDietMenuItem dietMenuItem  : menuItemList) 
				{
					if(dietMenuItem.getMenuType() != null){
						if(menuType.equals(dietMenuItem.getMenuType() )){
								%>
									itemArray[<%=count%>] = new Array();
									itemArray[<%=count%>][0]='<%=menuType%>';
									itemArray[<%=count%>][1] = <%=dietMenuItem.getDietItems().getId()%>;									
									itemArray[<%=count%>][2] = '<%=dietMenuItem.getDietItems().getDietItemsName()%>';		
								<%
								count++;
						}
					}
				}
			}
		%>
		
		</script>
	</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Diet Combination"
data_header[0][1] = "data";
data_header[0][2] = "30%";
data_header[0][3] = "<%= DIET_COMBINATION_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Menu Type"
data_header[1][1] = "data";
data_header[1][2] = "30%";
data_header[1][3] = "<%=MENU_TYPE %>";

data_header[2] = new Array;
data_header[2][0] = "Menu Item"
data_header[2][1] = "data";
data_header[2][2] = "30%";
data_header[2][3] = "<%=DIET_ITEMS_ID %>"

data_header[3] = new Array;
data_header[3][0] = "Qunatity"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=QUANTITY %>"

data_header[4] = new Array;
data_header[4][0] = "UOM"
data_header[4][1] = "data";
data_header[4][2] = "0";
data_header[4][3] = "<%=UNIT_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Patient Category"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%=PATIENT_CATEGORY %>";

data_header[6] = new Array;
data_header[6][0] = "Validity Start Date"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=VALID_FROM_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "40%";
data_header[7][3] = "<%=CHANGED_BY %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "0";
data_header[8][3] = "<%=CHANGED_DATE %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=STATUS %>";

data_arr = new Array();

<%

          int  counter=0;
         for(DietMenuItemFormula dietMenuItemFormula : menuItemFormulaList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= dietMenuItemFormula.getId()%>

<% 
	if(dietMenuItemFormula.getDietCombination() != null){
%>
<%
		for(MasDietCombination dietCombination : dietCombinationList){
            
			 if(dietMenuItemFormula.getDietCombination().getId().equals(dietCombination.getId()) && dietCombination.getStatus().equals("y")){%>
				data_arr[<%= counter%>][1] = "<%=dietCombination.getDietCombinationName()%>"
			<%}else if(dietMenuItemFormula.getId().equals(dietCombination.getId()) && dietCombination.getStatus().equals("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=dietCombination.getDietCombinationName()%>";
			<%}
            }
		}
%>
data_arr[<%= counter%>][2] = "<%= dietMenuItemFormula.getMenuType()%>"
<% 
	if(dietMenuItemFormula.getDietItems() != null){
%>
<%
		for(MasDietItems deitItems : dietItemsList){
            
			 if(dietMenuItemFormula.getDietItems().getId().equals(deitItems.getId()) && deitItems.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=deitItems.getDietItemsName()%>"
			<%}else if(dietMenuItemFormula.getId().equals(deitItems.getId()) && deitItems.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=deitItems.getDietItemsName()%>";
			<%}
            }
		}
%>

		data_arr[<%= counter%>][4] = "<%= dietMenuItemFormula.getQuantity()%>"

<% if(dietMenuItemFormula.getUnit() != null){
%>
<%
		for(MasStoreUnit storeUnit : uomList){
			 if(dietMenuItemFormula.getUnit().getId().equals(storeUnit.getId()) && storeUnit.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=storeUnit.getUnitName()%>"
			<%}else if(dietMenuItemFormula.getId().equals(storeUnit.getId()) && storeUnit.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=storeUnit.getUnitName()%>";
			<%}
            }
		}
%>
data_arr[<%= counter%>][6] = "<%= dietMenuItemFormula.getPatientCategory() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(dietMenuItemFormula.getValidityStartDate()) %>"
data_arr[<%= counter%>][8] = "<%= dietMenuItemFormula.getLastChgBy() %>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(dietMenuItemFormula.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= dietMenuItemFormula.getLastChgTime() %>"
<% if(dietMenuItemFormula.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "menuItemFormula"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	

