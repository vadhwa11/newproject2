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


<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	List<HrMasItaxExemption> searchItaxExemptMasterList = new ArrayList<HrMasItaxExemption>();
	List<MasStoreFinancial> hrMasFinancialYearList = new ArrayList<MasStoreFinancial>();
	if(map.get("searchItaxExemptMasterList")!=null)
	{
		searchItaxExemptMasterList =(List<HrMasItaxExemption>)map.get("searchItaxExemptMasterList");
	}
	if(map.get("hrMasFinancialYearList")!=null)
	{
		hrMasFinancialYearList =(List<MasStoreFinancial>)map.get("hrMasFinancialYearList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
	%>
	



<h4><%=message %></h4>
		<%  }
%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.HrMasItaxExemption"%>
<div class="titleBg"><h2>Income Tax Exemption Master</h2></div>
<div class="clear"></div>
<div class="Block">	 
	<div id="searcharea">
			<div id="searchbar">
		<form name="search" method="post" action="">
			<label>Financial Year</label> 
			<select name="<%= SEARCH_FIELD %>" id="searchField" validate="Financial Year,string,no" tabindex=1>
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
			<!--<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Finacial Year,string,no" MAXLENGTH="9" tabindex=1 />--> 
			<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','payrollMasters?method=searchIncomeTaxExemptJsp','chkfYear')" tabindex=1 />
			<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','payrollMasters?method=printItaxExepmtionMaster','chkfYear');" accesskey="g" tabindex=1/> -->
			
			<div class="clear"></div>
			<label>Copy Year</label>
			<input type="checkbox" name="copy" id="copy" value="no" onClick="checkYear()" class="Checkbox"/>
			
			
			<div id="copyYear" style="display:none;">
				<div class="clear"></div>
				<label>Copied From Year</label>
				<select id="copyFromYearId" name="copyFromYear" validate="Copy From Year,string,no" >
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
				<label>Copied To Year</label>
				<select id="copyToYearId" name="copyToYear" validate="Copy To Year,string,no" >
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
				<input type="button" name="copyYear" value="Copy" class="button" onclick="submitForm('search','payrollMasters?method=copyIncomeTaxExemptJsp','checkCopyYear')" tabindex=1 />
			</div>


			
		</form>
	 </div>
	</div>
	<div class="clear"></div>
</div>
	<div class="clear"></div>
    <div class="division"></div>		
    <form name="ancher" method="post">
</form>		
	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
 
	<%
 		if (searchItaxExemptMasterList.size() > 0) {
 			if (map.get("financialYear")!=null)  
 			{
 	%> 
	        <!-- <h4><a href="payrollMasters?method=showIncomeTaxExemptJsp">Show All Records</a></h4> -->
	        <h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showIncomeTaxExemptJsp');">Show All Records</a></h4>
	<%
			}
		}
		if (searchItaxExemptMasterList.size() == 0
				&& map.get("search") != null) {
	%>
			<!-- <h4><a href="payrollMasters?method=showIncomeTaxExemptJsp">Show All Records</a></h4> -->
			<h4><a href="javascript:void(0)" onclick="submitForm('ancher','payrollMasters?method=showIncomeTaxExemptJsp');">Show All Records</a></h4>

    <%
    	}
    %>

	<script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],  [1,"<%= SEARCH_NAME %>"],  [2,"<%= CODE %>"], [3,"maxAmt"], [4,"exemptionPercent"],[5,"exemptionBase"], [6,"minAmt"],[7,"maxExemption"],[8,"<%= CHANGED_BY%>"],[9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script>
	</div>
    <div class="clear"></div>
    <div class="division"></div>
   
  <form name="incomeTaxExempt" method="post" action="">
<div class="Block"> 
	
		<label>Section Code<span>*</span></label>
		<input type="text" name="<%= CODE %>" value="" validate="Section Code,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1/>
			
		
	    <label>Financial Year<span>*</span></label>
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
			
			<div class="clear"></div>	
			
			<label id="Label1">Maximum Amount<span>*</span></label>
			<input type="text" name="maxAmt" id="maxAmt" value="" validate="Max. Amount,floatWithoutZero,yes" class="textbox_size20" MAXLENGTH="12" tabindex=1  onChange="MinMaxAmtValidation()"/>
			
			<label id="Label2"> Minimum Amount <span>*</span></label>
			<input type="text" name="minAmt" id="minAmt" value=""  validate="Min. Amount,floatWithoutZero,yes" class="textbox_size20" MAXLENGTH="6" tabindex=1  onChange="MinMaxAmtValidation()"/>
			<div class="clear"></div>
			<label>Exemption Base<span>*</span></label>
			<select name="exemptionBase" validate="Exemption Base,string,yes" tabindex=1>
			<option value="">Select</option>
			<option value="s">Salary</option>
			<option value="t">Tax Amount</option>
			</select>
			
			<label>Exemption Percent<span>*</span></label>
			<input type="text" name="exemptionPercent" value="" validate="Exemption Percent,floatWithoutZero,yes" class="textbox_size20" MAXLENGTH="5" tabindex=1 />
			
			<label>Max. Exemption<span>*</span></label>
			<input type="text" name="maxExemption" value="" validate="Max. Exemption,floatWithoutZero,yes" class="textbox_size20" MAXLENGTH="13" tabindex=1 />
		
			<script>
				document.incomeTaxExempt.<%=SEARCH_FIELD%>.focus();
			</script>	
						
			<div class="clear"></div>
            </div>
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
			
			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('incomeTaxExempt','payrollMasters?method=addIncomeTaxExemptJsp');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('incomeTaxExempt','payrollMasters?method=editIncomeTaxExemptJsp')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('incomeTaxExempt','payrollMasters?method=deleteIncomeTaxExemptMaster&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onClick="submitFormForButton('incomeTaxExempt','payrollMasters?method=showIncomeTaxExemptJsp');" accesskey="r" />
			
		
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			</form>
	<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Financial Year"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= SEARCH_NAME %>"

data_header[1] = new Array;
data_header[1][0] = "Section Code"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= CODE%>";

data_header[2] = new Array;
data_header[2][0] = "Maximum Amount"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "maxAmt";

data_header[3] = new Array;
data_header[3][0] = "Exemption Percent"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "exemptionPercent";

data_header[4] = new Array;
data_header[4][0] = "Exemption Base"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "exemptionBase";


data_header[5] = new Array;
data_header[5][0] = "Minimum Amount"
data_header[5][1] = "data";
data_header[5][2] = "";
data_header[5][3] = "minAmt";

data_header[6] = new Array;
data_header[6][0] = "Max. Exemption"
data_header[6][1] = "data";
data_header[6][2] = "";
data_header[6][3] = "maxExemption";



data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_BY %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_DATE %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "";
data_header[9][3] = "<%=CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "";
data_header[10][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchItaxExemptMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrMasItaxExemption  hrMasItaxExemption = (HrMasItaxExemption)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasItaxExemption.getId()%>
<%
	for(MasStoreFinancial hrMasFinancialYear :hrMasFinancialYearList){
		if(hrMasItaxExemption.getFinancialYear().getId().equals(hrMasFinancialYear.getId())){
%>

data_arr[<%= counter%>][1] = "<%=hrMasFinancialYear.getFinancialYear()%>"
<% 
	}
   }		

%>
 
data_arr[<%= counter%>][2] = "<%= hrMasItaxExemption.getSectionCode()%>"
data_arr[<%= counter%>][3] = "<%= hrMasItaxExemption.getMaximumAmt()%>"
data_arr[<%= counter%>][4] = "<%= hrMasItaxExemption.getExemptionPercentage()%>"


<% if(hrMasItaxExemption.getExemptionBase().equals("s")){ %>
data_arr[<%= counter%>][5] = "Salary"
<%}else{%>
data_arr[<%= counter%>][5] = "Tax Amount"
<%}%>
data_arr[<%= counter%>][6] = "<%= hrMasItaxExemption.getMinimumAmt()%>"

data_arr[<%= counter%>][7] = "<%= hrMasItaxExemption.getMaxExemption()%>"

	data_arr[<%= counter%>][8] = "<%= hrMasItaxExemption.getLastChgBy()!=null?(hrMasItaxExemption.getLastChgBy().getId()!=null?hrMasItaxExemption.getLastChgBy().getId():"0" ):"0"%>"

data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasItaxExemption.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= hrMasItaxExemption.getLastChgTime() %>"
<% if(hrMasItaxExemption.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>


<%
		     counter++;
}
%>
 
formName = "incomeTaxExempt"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	


</script>

<script type="text/javascript">
function checkYear()
		{
		
		if(document.getElementById('copy').checked)
		{
			document.getElementById('copyYear').style.display='block';
		}
		else
		{
		    document.getElementById('copyYear').style.display='none';
		   
		}
		
	}
	
	
	function checkCopyYear()
		{
		
		if(document.getElementById('copyFromYearId').value == "0")
		{
		    alert("From Year can not be Blank");
			return false;
		}
		else if(document.getElementById('copyToYearId').value == "0")
		{
		    alert("To Year can not be Blank");
		    return false;
		   
		}
		else if(document.getElementById('copyToYearId').value == document.getElementById('copyFromYearId').value)
		{
		    alert("From Year and To Year can not be Same");
		    return false;
		   
		}
		return true;
		
		
	}
	
	
		function chkfYear(){
			var chk = document.getElementById('searchField').value;
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


		function MinMaxAmtValidation(){

			var minAmount = document.getElementById("minAmt").value;
			var maxAmount = document.getElementById("maxAmt").value;
			
			var MinimumAmt=parseInt(minAmount);
			var MaximumAmt=parseInt(maxAmount);
			
			
			var miAmt= document.getElementById('Label2').innerText.replace(/\*/g, ' ');
			var maAmt= document.getElementById('Label1').innerText.replace(/\*/g, ' '); 
		 	
			if(MaximumAmt< MinimumAmt) 
			{ 
			alert(maAmt+" cannot less than "+miAmt);
			document.getElementById('maxAmt').value="";
			return false; 
		}	 
			}

		

	</script>
	