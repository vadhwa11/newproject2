<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_instructorMaster.jsp  
 * Purpose of the JSP -  This is for Instructor details 
 * @author  Vishal
 * Create Date: 23rd Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrMasItaxSlab"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.cal.js"></script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	List<HrMasItaxSlab> searchItaxSlabMasterList = new ArrayList<HrMasItaxSlab>();
	List<MasStoreFinancial> hrMasFinancialYearList = new ArrayList<MasStoreFinancial>();
	if(map.get("searchItaxSlabMasterList")!=null)
	{
		searchItaxSlabMasterList =(List<HrMasItaxSlab>)map.get("searchItaxSlabMasterList");
	}
	if(map.get("hrMasFinancialYearList")!=null)
	{
		hrMasFinancialYearList =(List<MasStoreFinancial>)map.get("hrMasFinancialYearList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
%>

<div class="titleBg"><h2>Income Tax Slab</h2></div>
<div class="clear"></div>
<div class="Block">	 
	<div id="searcharea">
			<div id="searchbar">
		<form name="search" method="post" action="">
			<label>Financial Year</label> 
			<select name="<%=SEARCH_FIELD_NEXT%>" id="searchFieldNext" validate="Financial Year,string,no" tabindex=1>
			<option value="0">Select</option>
			<%if(hrMasFinancialYearList != null)
			{
				for(MasStoreFinancial hrMasFinancial : hrMasFinancialYearList)	
				{%>
					<option value="<%=hrMasFinancial.getId()%>" ><%=hrMasFinancial.getFinancialYear() %></option>
				<% }
			}
			%>			    
			</select>	
			
			<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheck" />
			<label>Tax Rate</label>
			<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />
			 
			<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Tax Rate,string,no" MAXLENGTH="8" tabindex=1 /> 
			<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','incomeTaxMaster?method=searchItaxSlabMaster')" tabindex=1 />
			<div class="clear"></div>
			<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','incomeTaxMaster?method=printItaxSlabMaster','chkfYear');" accesskey="g" tabindex=1/>
		</form>
	 </div>
	</div>
	<div class="clear"></div>
</div>
<form name="ancher" method="post">
</form>
	<div class="clear"></div>
    <div class="division"></div>				
	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
 
	<%
 		if (searchItaxSlabMasterList.size() > 0) {
 			
 			String financialYr = (String) map.get("financialYear");
 			Float fltTaxRate = (Float) map.get("taxRate");
 			if (financialYr != null && financialYr != "" || fltTaxRate != null && fltTaxRate != 0.0 ) 
 			{
 	%> 
	       <!--  <h4><a href="incomeTaxMaster?method=showIncomeTaxSlabJsp">Show All Records</a></h4> -->
	       <h4><a href="javascript:void(0)" onclick="submitForm('ancher','incomeTaxMaster?method=showIncomeTaxSlabJsp');">Show All Records</a></h4>
	<%
			}
		}
		if (searchItaxSlabMasterList.size() == 0
				&& map.get("search") != null) {
	%>
			<!-- <h4><a href="incomeTaxMaster?method=showIncomeTaxSlabJsp">Show All Records</a></h4> -->
			<h4><a href="javascript:void(0)" onclick="submitForm('ancher','incomeTaxMaster?method=showIncomeTaxSlabJsp');">Show All Records</a></h4>

    <%
    	}
    %>

	<script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],  [1,"<%= SEARCH_NAME %>"],  [2,"<%= LOWER_LIMIT %>"], [3,"<%= UPPER_LIMIT %>"], [4,"<%= CODE %>"], [5,"citizen"],[6,"<%= CHANGED_BY%>"],[7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	</script>
	</div>
    <div class="clear"></div>
    <div class="division"></div>
   <div class="Block"> 
  <form name="incomeTaxSlab" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "HrMasItaxSlab"/>
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "FinancialYear"/>
  <input type="hidden" name="title" value = "IT Slab"/>
  <input type="hidden" name="<%=JSP_NAME %>" value = "hr_incomeTaxSlab"/>
  <input type="hidden" name="pojoPropertyCode" value = "TaxRate"/>
	
	    <label><span>*</span>  Financial Year</label>
			<select name="<%= SEARCH_NAME %>" validate="Financial Year,string,yes" tabindex=1>
			<option value="">Select</option>
			<%if(hrMasFinancialYearList != null)
			{
				for(MasStoreFinancial hrMasFinancial : hrMasFinancialYearList)	
				{%>
					<option value="<%=hrMasFinancial.getId()%>" ><%=hrMasFinancial.getFinancialYear() %></option>
				<% }
			}
			%>			    
			</select>	
			
			<label><span>*</span>  Citizen </label>
			<select name="citizen" validate="Sex,string,yes" tabindex=1>
			
			<option value="">Select</option>
			    <option value="m">Male</option>
			    <option value="f">Female</option>
			    <option value="s">Senior Citizen</option>
			</select>	
			<div class="clear"></div>	
			
				
			<label><span>*</span>  Lower Limit </label>
			<input type="text" name="<%= LOWER_LIMIT %>" value="" validate="Lower Limit,string,no" class="textbox_size20" MAXLENGTH="19" tabindex=1/>
			
			<label><span>*</span>Upper Limit</label>
			<input type="text" name="<%= UPPER_LIMIT %>" value="" validate="Upper Limit,string,no" class="textbox_size20" MAXLENGTH="19" tabindex=1 />
			
			<label><span>*</span>Tax Rate</label>
			<input type="text" name="<%= CODE %>" value="" class="textbox_size20" MAXLENGTH="6"/ tabindex=1 />
			<script>
				document.incomeTaxSlab.<%=SEARCH_FIELD%>.focus();
			</script>	
						
			<div class="clear"></div>
          
            <div class="clear"></div>
            <div class="division"></div>
			<div class="bottom">
			<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   			</div>		
		
	        <div class="division"></div>
				
			<div id="edited"></div>
			
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('incomeTaxSlab','incomeTaxMaster?method=addIncomeTaxSlabMaster');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('incomeTaxSlab','incomeTaxMaster?method=editIncomeTaxSlabMaster')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('incomeTaxSlab','incomeTaxMaster?method=deleteIncomeTaxSlabMaster&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			
		
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
	</form>
</div>		
	<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Financial Year"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= SEARCH_NAME %>"

data_header[1] = new Array;
data_header[1][0] = "Lower Limit"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= LOWER_LIMIT%>";

data_header[2] = new Array;
data_header[2][0] = "Upper Limit"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "<%= UPPER_LIMIT%>";

data_header[3] = new Array;
data_header[3][0] = "Tax Rate"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "<%= CODE%>";

data_header[4] = new Array;
data_header[4][0] = "Citizen"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "citizen";

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
data_header[7][2] = "";
data_header[7][3] = "<%=CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "";
data_header[8][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchItaxSlabMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrMasItaxSlab  hrMasItaxSlab = (HrMasItaxSlab)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasItaxSlab.getId()%>
<%
	for(MasStoreFinancial hrMasFinancialYear :hrMasFinancialYearList){
		if(hrMasItaxSlab.getFinancialYear().getId().equals(hrMasFinancialYear.getId())){
%>

data_arr[<%= counter%>][1] = "<%=hrMasFinancialYear.getFinancialYear()%>"
<% 
	}
   }		

%>
 
data_arr[<%= counter%>][2] = "<%= hrMasItaxSlab.getLowerLimit()%>"
data_arr[<%= counter%>][3] = "<%= hrMasItaxSlab.getUpperLimit()%>"
data_arr[<%= counter%>][4] = "<%= hrMasItaxSlab.getTaxRate()%>"

<% if(hrMasItaxSlab.getCitizen().equals("f")){ %>
data_arr[<%= counter%>][5] = "Female"
<%}else if(hrMasItaxSlab.getCitizen().equals("m")){%>
data_arr[<%= counter%>][5] = "Male"
<%}else if(hrMasItaxSlab.getCitizen().equals("s")){%>
data_arr[<%= counter%>][5] = "Senior Citizen"
<%}%>
data_arr[<%= counter%>][6] = "<%= hrMasItaxSlab.getLastChgBy() %>"
<%if(hrMasItaxSlab.getLastChgDate()!=null){%>
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasItaxSlab.getLastChgDate()) %>"
<%}else
{%>
data_arr[<%= counter%>][7] = ""
<%}%>
data_arr[<%= counter%>][8] = "<%= hrMasItaxSlab.getLastChgTime() %>"
<% if(hrMasItaxSlab.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>


<%
		     counter++;
}
%>
 
formName = "incomeTaxSlab"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		

function chkfYear(){
var chk = document.getElementById('searchFieldNext').value;
if(chk != 0 ){
     return true;
}
else
{
  alert("Please Select Financial Year for Reports!!!");
   return false;
}
return true;
}




</script>	